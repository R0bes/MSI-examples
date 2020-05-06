
#include "primes.h"

#include <stdio.h>
#include <stdlib.h>

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

	struct calculation calc = { from, to, 0, 0 };

	count_primes(&calc);

	printf("Found: %d primes in %f seconds\n", calc.count, calc.time);
}
