
#include "primes.h"

#include <stdio.h>
#include <stdlib.h>
#include <cilk/cilk.h>


int main (int argc, char *argv[])
{
	if (argc != 3) {
		printf("Enter values for range [from;to]\n");
		return -1;
	}

	int from 	= atoi (argv[1]);
	int to 		= atoi (argv[2]);

	if(from < 0) {
		printf("Enter positive value for lower border\n");
		return -1;
	}

	if(to < from) {
		printf("Upper border is lower than lower border\n");
		return -1;
	}


	int part = (to - from) / 4;
	if(part * 4 != (to - from)) {
		printf("Range not dividable by 4\n");
		return -1;
	}

	struct calculation calc_cores[4];
	for (int i = 0; i < 4; i++) {
		calc_cores[i].count = 0;
		calc_cores[i].time = 0;
		calc_cores[i].from = from + i * part;
		calc_cores[i].to = (i + 1) * part;
	}

//	cilk_spawn count_primes(&calc_cores[0]);
//	cilk_spawn count_primes(&calc_cores[1]);
//	cilk_spawn count_primes(&calc_cores[2]);
//	count_primes(&calc_cores[3]);
//	cilk_sync;

	cilk_for(int i = 0; i < 4; i++) {
	   	count_primes(&calc_cores[i]);
	}

	int count_sum = calc_cores[0].count + calc_cores[1].count + calc_cores[2].count + calc_cores[3].count;

	double time_max = 0;
	for(int i = 0; i < 4; i++) if(time_max < calc_cores[i].time) time_max = calc_cores[i].time;

	printf("Found: %d primes in %f seconds\n", count_sum, time_max);
}
