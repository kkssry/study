|  <center>정규식 패턴</center> |  <center>설명</center> |  <center>결과</center> |
|:--------|:--------:|--------:|
|c [a-z]* | **<center>c로 시작하는 영단어 </center>** |*c, ca, co, car, combat,*|
|c [a-z] | **<center>c로 시작하는 두자리 영단어 </center>** |*ca, co,* |
|c [a-zA-z] | **<center>c로 시작하는 두자리 영단어(a~z 또는 A~Z, 즉 대소문자 구분 안함) </center>** |*cA, ca, co,* |
|c [a-zA-Z0-9], c \w | **<center> c로 시작하고 숫자와 영어로 조합된 두 글자 </center>**|*cA, ca, co, c0,* |
|.* | **<center>모든 문자열 </center>** |*bat, baby, bonus, c, cA, ca, co, c., c0, c#, car, combat, count, date, disc,* |
|c . | **<center>c로 시작하는 두자리 문자열 </center>** |*cA, ca, co, c., c0, c#,* |
|c .* | **<center>c로 시작하는 모든 문자열 (기호포함) </center>** |*cA, ca, co, c., c0, c#, car, combat, count,* |
|c \\. | **<center>c.와 일치하는 문자열 '.'은 패턴작성에 사용되는 문자이므로 escape문자인 '\\'를 사용해야 한다. </center>** |*c. ,* |
|c \\d, c [0-9] | **<center>c와 숫자로 구성된 두자리 문자열 </center>** |*c0 ,* |
|c .*t | **<center>c로 시작하고 t로 끝나는 모든 문자열 </center>** |*combat, count,* |
|[b\|c] .* , [bc] .* , [b-c] .* | **<center> b 또는 c로 시작하는 문자열 </center>** |*bat, baby, bonus, c, cA, ca, co, c., c0, c#, car, combat, count,* |
|[^b\|c] .* , [^bc] .* , [^b-c] .* | **<center>b또는 c로 시작하지 않는 문자열 </center>** |*date, disc* |
|.* a .* | **<center>a를 포함하는 모든 문자열 </center>** |*bat, baby, ca, car, combat, date* |
|.*a.+ | **<center>a를 포함하는 모든 문자열. + : 1또는 그 이상의 문자. '+'는 '*'과는 달리 반드시 하나 이상의 문자가 있어야 하므로 a로 끝나는 단어는 포함되지 않는다.</center>** |*bat, baby, car, combat, date* |
| [b \| c] . {2} | **<center>b또는 c로 시작하는 세 자리 문자열. (b또는 c 다음에 두자리이므로 모두 세자리) </center>** |*bat, car* |

