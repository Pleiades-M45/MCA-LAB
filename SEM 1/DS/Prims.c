#include<stdio.h>
int visited[10] = {0}, cost[10][10], min, mincost = 0;

int input(int num)
{
    int i, j;
    printf("\nEnter the adjacency matrix\n\n");
    for (i = 1; i <= num; i++)
    {
        for (j = 1; j <= num; j++)
        {
            printf("value of cost[%d][%d]: ", i, j);
            scanf("%d", &cost[i][j]);
        }
    }
    return 0;
}

int display(int num)
{
    int i, j;
    printf("\nThe cost of adjacency matrix\n\n");
    for (i = 1; i <= num; i++)
    {
        for (j = 1; j <= num; j++)
        {
            printf("%d\t", cost[i][j]);
        }
        printf("\n");
    }
    return 0;
}

int prims(int num)
{
    int i, j, ne = 1, a, b;
    for (i = 1; i <= num; i++)
    {
        for (j = 1; j <= num; j++)
        {
            if (cost[i][j] == 0)
                cost[i][j] = 999;
        }
    }
    visited[1] = 1;
    while (ne < num)
    {
        for (i = 1, min = 999; i <= num; i++)
        {
            for (j = 1; j <= num; j++)
            {
                if (cost[i][j] < min && visited[i] != 0)
                {
                    min = cost[i][j];
                    a = i;
                    b = j;
                }
            }
        }
        printf("\n Edge %d:(%d - %d) cost:%d", ne++, a, b, min);
        mincost += min;
        visited[b] = 1;
        cost[a][b] = cost[b][a] = 999;
    }
    printf("\n\n\n Minimum cost = %d", mincost);
}

int main()
{
    int num;
    printf("\n\t\t\tPrim's Algorithm");
    printf("\n\nEnter the number of nodes: ");
    scanf("%d", &num);
    input(num);
    display(num);
    prims(num);
    return 0;
}