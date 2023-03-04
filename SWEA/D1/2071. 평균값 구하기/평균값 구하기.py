T=int(input())
for tc in range(1,T+1):
    lst=list(map(int, input().split()))
    
    cnt = 0
    for i in range(10):
        cnt += lst[i]
    
    avg = round(cnt / 10)
    
    print(f'#{tc} {avg}')