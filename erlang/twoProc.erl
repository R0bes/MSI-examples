
-module(twoProc).
-export([start/1, procA/2, procB/0]).

-define(_A(S, A), io:format("\e[31m A: " ++ S ++ "~n\e[39m", A)).
-define(_B(S, A), io:format("\e[34m B: " ++ S ++ "~n\e[39m", A)).

procA(0, PID_B) ->
	PID_B ! finished,
	?_A("A finished", []);

procA(N, PID_B) ->
	VAL_A = rand:uniform(100),
	?_A("send ~p", [VAL_A]),
	PID_B ! {ping, VAL_A, self()},
	receive
		VAL_B ->
			?_A("got ~p", [VAL_B])
	end,
	procA(N - 1, PID_B).

procB() ->
	receive
		finished ->
			?_B("finished", []);
		{ping, VAL_A, PID_A} ->
			?_B("got ~p", [VAL_A]),
			VAL_B = rand:uniform(100),
			?_B("send ~p", [VAL_B]),
			PID_A ! VAL_B,
			procB()
	end.

start(N) ->
	PID = spawn(twoProc, procB, []),
	spawn(twoProc, procA, [N, PID]).

