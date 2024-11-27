#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#define MAX 10
#define INF 999  // Use a constant to represent infinity

int parent[MAX];
int rank[MAX];  // To store the rank for union by rank
int v, i, j, cost[MAX][MAX], edgecount, count = 1, mincost, c, rno, cno, v1, v2, k;

// Find function with path compression
int find(int i) {
    if (parent[i] != i) {
        parent[i] = find(parent[i]);  // Path compression
    }
    return parent[i];
}

// Union function with union by rank
int uni(int i, int j) {
    int root1 = find(i);
    int root2 = find(j);

    // If both roots are different, perform union
    if (root1 != root2) {
        // Union by rank
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
        return 1;  // Successfully united
    }
    return 0;  // No union, cycle detected
}

int main() {
    clrscr();
    // Input number of vertices
    printf("Total number of vertices: ");
    scanf("%d", &v);

    // Initialize parent and rank arrays
    for (i = 1; i <= v; i++) {
        parent[i] = i;  // Initially, each vertex is its own parent
        rank[i] = 0;     // Initially, rank is 0
    }

    // Get edge weight matrix from the user
    for (i = 1; i <= v; i++) {
        for (j = i + 1; j <= v; j++) {
            printf("Enter the cost[%d][%d] (or 0 for no edge): ", i, j);
            scanf("%d", &cost[i][j]);
            cost[j][i] = cost[i][j];  // Because the graph is undirected

            // If no edge exists between i and j, set cost to INF
            if (cost[i][j] == 0) {
                cost[i][j] = INF;
                cost[j][i] = INF;
            }
        }
    }

    // Initialize the edge count (for MST, we need v-1 edges)
    edgecount = v - 1;
    mincost = 0;  // Initialize minimum cost

    // Kruskal's algorithm to find MST
    while (count <= edgecount) {
        c = INF;  // Initialize the minimum edge cost to INF

        // Find the smallest edge that hasn't been processed yet
        for (i = 1; i <= v; i++) {
            for (j = 1; j <= v; j++) {
                if (cost[i][j] < c) {
                    c = cost[i][j];
                    v1 = rno = i;
                    v2 = cno = j;
                }
            }
        }

        // Check if including this edge forms a cycle (using union-find)
        rno = find(rno);
        cno = find(cno);

        if (uni(rno, cno)) {
            // If no cycle, include this edge in the MST
            printf("Edge %d is (%d -> %d) with cost: %d\n", count++, v1, v2, c);
            mincost += c;
        }

        // Mark this edge as processed by setting its cost to INF
        cost[v1][v2] = cost[v2][v1] = INF;
    }

    // Output the total minimum cost of the MST
    printf("\nMinimum cost of the MST = %d\n", mincost);
    getch();
    return 0;
}
