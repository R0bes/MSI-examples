
# MSI-examples
## Beispiele zur Multicore-Programmierung

### clik
* Infos & Beispiele: http://cilk.mit.edu/
* Der Tapir/LLVM Compiler ist der neueste Compiler für Cilk:
 https://github.com/wsmoses/Tapir-Meta
 * Gute Anleitung: https://nanxiao.me/en/first-taste-of-building-cilk-program-on-arch-linux/

Cilk-Quellen werden benötigt um die */cilk* Beispiele auszuführen.<br/>
Kann mit<br/>
*$ cd cilk && make*<br/> 
gebaut werden, dann ausgeführt mit<br/>
*$ ./outdir/count_primes_seq \<from\> \<to\>*<br/>
*$ ./outdir/count_primes_par \<from\> \<to\>*


### kotlin
* Home/Tutorials: https://kotlinlang.org/
* Intellij (empfohlene Umgebung): https://www.jetbrains.com/de-de/idea/download/
* Linux: sudo snap install kotlin --classic

Kotlin installation wird für das */kotlin* Beispiel benötigt. <br/>
Dann kann mit <br/>
*$ kotlinc kotlin/src/\* -include-runtime -d kotlin_example.jar* <br/>
gebaut werden und mit<br/>
*$ java -jar kotlin_example.jar*<br/>
ausgeführt.

### erlang
* Windows: https://www.erlang.org/downloads
* Linux: *$ sudo apt install erlang-base*

*$ erl* startet die erlang-Konsole<br/>
Das */erlang* Beispiel kann dann mit <br/>
*> c(twoProc).* <br/>
gebaut und mit <br/>
*twoProc:start(\<value\>).* <br/>
ausgeführt werden.

