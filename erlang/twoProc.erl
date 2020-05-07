
-module(twoProc).
-export([start/1, processA/2, processB/0]).

-define(_A(S, A), io:format("\e[31m A: " ++ S ++ "~n\e[39m", A)).
-define(_B(S, A), io:format("\e[34m B: " ++ S ++ "~n\e[39m", A)).

processA(0, PID_B) ->
	PID_B ! finish,
	?_A("finished", []);

processA(N, PID_B) ->
	VAL_A = rand:uniform(100),
	?_A("send ~p", [VAL_A]),
	PID_B ! {myValue, VAL_A, self()},
	receive
		VAL_B ->
			?_A("got ~p", [VAL_B])
	end,
	processA(N - 1, PID_B).

processB() ->
	receive
		finish ->
			?_B("finished", []);
		{myValue, VAL_A, PID_A} ->
			?_B("got ~p", [VAL_A]),
			VAL_B = rand:uniform(100),
			?_B("send ~p", [VAL_B]),
			PID_A ! VAL_B,
			processB()
	end.

start(N) ->
	PID = spawn(twoProc, processB, []),
	spawn(twoProc, processA, [N, PID]).

