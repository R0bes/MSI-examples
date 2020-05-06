
.PHONY: all clean

SRC=src
OBJ=obj
OUT=outdir
LIB=-fcilkplus

all: count_primes_seq count_primes_par

count_primes_seq: $(OUT)/count_primes_seq
count_primes_par: $(OUT)/count_primes_par


$(OUT)/count_primes_par: $(OUT) $(OBJ)/primes.o $(OBJ)/count_primes_par.o
	gcc $(OBJ)/count_primes_par.o $(OBJ)/primes.o -lm -fcilkplus -o $@

$(OBJ)/count_primes_par.o: $(OBJ) $(SRC)/count_primes_par.c $(SRC)/primes.h
	gcc -c $(SRC)/count_primes_par.c -fcilkplus -o $@
	
	

$(OUT)/count_primes_seq: $(OUT) $(OBJ)/primes.o $(OBJ)/count_primes_seq.o
	gcc $(OBJ)/count_primes_seq.o $(OBJ)/primes.o -lm -o $@

$(OBJ)/count_primes_seq.o: $(OBJ) $(SRC)/count_primes_seq.c $(SRC)/primes.h
	gcc -c $(SRC)/count_primes_seq.c -o $@
	
	

$(OBJ)/primes.o: $(OBJ) $(SRC)/primes.c $(SRC)/primes.h
	gcc -c $(SRC)/primes.c -o $@

$(OBJ): 
	mkdir -p $(OBJ)
	
$(OUT): 
	mkdir -p $(OUT)
	
clean: 
	rm -rf $(OBJ) $(OUT)
	
	
	
	
	
	
	
	
	
	