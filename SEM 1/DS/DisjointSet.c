#include <stdio.h>
#define MAX 100

int parent[MAX];
int rank[MAX];

void makeSet(int n) {
    for (int i = 0; i < n; i++) {
        parent[i] = i;  // Each element is its own parent
        rank[i] = 0;    // Initialize rank to 0
    }
}

// Function to find the root of an element with path compression
int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]);   // Path compression
    }
    return parent[x];
}

void unionSets(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

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
        printf("Union of %d and %d performed.\n", x, y);
    }
    else {
        printf("%d and %d are already in the same set.\n", x, y);
    }

}

void display(int n) {
    printf("\nElement\tParent\tRank\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%d\t%d\n", i, parent[i], rank[i]);
    }
}

int main() {
    int n, ch, x, y;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    makeSet(n);


    while (1) {
        printf("\n1. Find\n");
        printf("2. Union\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
        case 1: printf("Enter element to find its root: ");
                scanf("%d", &x);
                if (x >= 0 && x < n) {
                    printf("Root of %d is %d.\n", x, find(x));
                } else {
                    printf("Invalid element! Enter a value between 0 and %d.\n", n - 1);
                }
                break;

            
        case 2: printf("Enter two elements to perform union: ");
                scanf("%d %d", &x, &y);

                if (x >= 0 && x < n && y >= 0 && y < n) {
                    unionSets(x, y);
                    display(n);
                } else {
                    printf("Invalid elements! Enter values between 0 and %d.\n", n - 1);
                }
                break;

        case 3: printf("Exiting program.\n");
                return 0;

        default: printf("Invalid choice! Please try again.\n");
        }
    }
}