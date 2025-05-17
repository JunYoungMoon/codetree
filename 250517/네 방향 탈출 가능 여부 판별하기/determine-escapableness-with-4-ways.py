# 이차원 배열 bfs
from collections import deque
n, m = map(int, input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]

def bfs():
    dirs = [(1,0),(0,1),(-1,0),(0,-1)]
    while q:
        x,y = q.popleft()
        for i in range(4): 
            nx = x + dirs[i][0]  #1 0 -1 0
            ny = y + dirs[i][1]  #0 1  0 -1
            if 0 <=nx < n and 0<= ny < m and not visited[nx][ny] and graph[nx][ny] !=0:  # 갈 수 있는 곳 
                q.append((nx,ny))
                visited[nx][ny] =1




        
q= deque()
visited[0][0] =1
q.append((0,0))
print(visited[n-1][m-1])





