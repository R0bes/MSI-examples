
# MSI-examples
## Beispiele zur Multicore-Programmierung

### clik
* Infos & Beispiele: http://cilk.mit.edu/
* Der Tapir/LLVM Compiler ist der neueste Compiler für Cilk:
 https://github.com/wsmoses/Tapir-Meta
 * Gute Anleitung: https://nanxiao.me/en/first-taste-of-building-cilk-program-on-arch-linux/

Cilk-Quellen werden benötigt um die */cilk* Beispiele auszuführen.
Kann mit 
*$ cd cilk && make* 
gebaut werden, dann ausgeführt mit
*$ ./outdir/count_primes_seq \<from\> \<to\>*
*$ ./outdir/count_primes_par \<from\> \<to\>*


### kotlin
* Home/Tutorials: https://kotlinlang.org/
* Intellij (empfohlene Umgebung): https://www.jetbrains.com/de-de/idea/download/
* Linux: sudo snap install kotlin --classic

Kotlin installation wird für das */kotlin* Beispiel benötigt. 
Dann kann mit 
*$ kotlinc kotlin/src/\* -include-runtime -d kotlin_example.jar* 
gebaut werden und mit
*$ java -jar kotlin_example.jar*
ausgeführt.

### erlang
* Windows: https://www.erlang.org/downloads
* Linux: *$ sudo apt install erlang-base*

*$ erl* startet die erlang-Konsole
Das */erlang* Beispiel kann dann mit 
*> c(twoProc).* 
gebaut und mit 
*twoProc:start(\<value\>).* 
ausgeführt werden.

