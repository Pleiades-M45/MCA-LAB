#include <stdio.h>
#define MAX 10
#define INF 999  // Use a constant to represent infinity

int parent[MAX];
int rank[MAX];  // To store the rank for union by rank
int v, i, j, cost[MAX][MAX], edgecount, count = 1, mincost, c, rno, cno, v1, v2, k;

// Function to find the root of an element with path compression
int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]);   // Path compression
    }
    return parent[x];
}

// Union function with union by rank
int unionSets(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    // If both roots are different, perform union
    if (rootX != rootY) {
        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;  
        }
        return 1;  // Successfully united
    }
    return 0;  // No union, cycle detected
}

int main() {
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

    edgecount = v - 1;  // Initialize the edge count (for MST, we need v-1 edges)
    mincost = 0; 

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

        if (unionSets(rno, cno)) {
            // If no cycle, include this edge in the MST
            printf("Edge %d is (%d -> %d) with cost: %d\n", count++, v1, v2, c);
            mincost += c;
        }

        // Mark this edge as processed by setting its cost to INF
        cost[v1][v2] = cost[v2][v1] = INF;
    }

    printf("\nMinimum cost of the MST = %d\n", mincost);
    return 0;
}
