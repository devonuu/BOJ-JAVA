# 백준 알고리즘 / 프로그래머스 문제풀이 `소스` 저장소
## BOJ > 재귀 ( recursion )
* [하노이 탑 이동 순서] (#Num11729)
* [압축] (#Num1662)

### Num11729
[`하노이 탑 이동 순서`](https://www.acmicpc.net/problem/11729)
* 가장 밑에 원판이 목적지에 가려면 그 원판을 제외한 나머지 원판들은 순서대로 목적지가 아닌 다른 곳에 쌓여 있어야 한다
* 재귀는 두가지로 분기 된다.
    1. 가장 밑 (N번째) 원판이 목적지로 가는 재귀
    2. 그 다음번째 원판들( 1~(N-1) )이 목적지로 가는 재귀
* 가장 큰 원판이 움직일 수 있도록 나머지 원판들이 경유지로 비켜주고 가장 큰 원판이 움직인다.
* 포인트는 각 재귀의 깊이 마다 `목적지`와 `경유지`가 `바뀐다`는 사실을 인지하는 것이다.
* 원판의 개수가 짝수인지 홀수인지에 따라서도 처음 움직이는 원판의 위치도 달라진다.

### Num1662
[`압축`](https://www.acmicpc.net/problem/1662)
* K(Q) 패턴의 반복이기 때문에 재귀를 통해 해당 패턴을 반복할 수 있도록 만들어주면 되지 않을까..?
* K(Q) 패턴을 만드려면 여는 괄호`(`의 INDEX와 닫는괄호`)`의 INDEX를 가지고 있어야 범위를 정할 수 있겠다 싶다.
* 재귀는 여는 괄호`(`를 만났을때 깊어진다. 여는 괄호 다음부터 닫는 괄호가 나올때까지 내부 문자열의 개수만큼 더해주고 괄호가 닫히면 반복문을 종료한 후 
  괄호안의 문자개수를 `return` 해준다.
* 한쌍의 괄호 안에 또다른 괄호가 몇개든 상관없이 여는 괄호 다음에 마주치는 닫는 괄호는 무조건 한쌍이기 때문에 괄호 하나 단위로 재귀의 깊이를 더해준다.