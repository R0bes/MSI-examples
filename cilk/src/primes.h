#ifndef PRIMES_H
#define PRIMES_H

struct calculation {
	int from;
	int to;
	int count;
	double time;
};

int is_prime (int value);

void count_primes(struct calculation* calc);


#endif // PRIMES_H
