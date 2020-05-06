
#include "primes.h"

#include <stdio.h>
#include <math.h>		// sqrt
#include <time.h>		// clock


int is_prime (int value) {
	if (value <= 1) return 0;
	double n = (int) floor (sqrt (value));
	for(int i = 2; i <= n; i++)
		if (value % i == 0)	return 0;
	return 1;
}


void count_primes(struct calculation* calc) {
    clock_t start = clock();
	for(int i = calc->from; i < calc->to; i++) {
		if (is_prime (i)) calc->count++;
	}
	clock_t end = clock();
	calc->time = ((double) (end - start)) / CLOCKS_PER_SEC;
}
