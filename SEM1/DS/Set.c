#include <stdio.h>
int u[10], a[10], b[10], p, q, n;

void display(int x[]) {
    int i;

    printf("{");
    for (i = 0; i < n-1; i++)
	    printf("%d, ", x[i]);
    printf("%d}", x[n-1]);
}

void displaySet(int x[]) {
    int i, first = 1;

    printf("{");
    for (i = 0; i < n; i++) {
        if (x[i] == 1) {  // If the element is present in the set (i.e., bit is 1)
            if (!first) {
                printf(", ");
            }
            printf("%d", u[i]);
            first = 0;
        }
    }
    printf("}\n");
}

int pos(int x) {
    int i;
    for (i = 0; i < n; i++) {
        if (u[i] == x)
            return i;
    }
    return -1;  // Element not found
}

void setunion() {
    int i;
    printf("\nUnion : ");
    for (i = 0; i < n; i++) {
        if ((a[i] | b[i]) == 1) 
	        printf("%d ", u[i]);
    }
}

void intersect() {
    int i;
    printf("\nIntersection : ");
    for (i = 0; i < n; i++) {
        if ((a[i] & b[i]) == 1) 
	        printf("%d ", u[i]);
    }
}

void setdiff() {
    int i;
    printf("\nDifference (A - B): ");
    for (i = 0; i < n; i++) {
        if ((a[i] & !b[i]) == 1) 
	        printf("%d ", u[i]);
    }
}

int main() {
    int i, x;

    printf("Enter size of universal set: ");
    scanf("%d", &n);
    printf("Enter elements of the universal set: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &u[i]);
        a[i] = b[i] = 0;  // Initialize bit strings to 0 (non-membership)
    }

    printf("\nEnter size of set 1: ");
    scanf("%d", &p);
    printf("Enter elements of set 1: ");
    for (i = 0; i < p; i++) {
	    scanf("%d", &x);
        if (pos(x) != -1) 
            a[pos(x)] = 1;
        /* else 
             printf("Element %d not found in the universal set.\n", x);  */
    }

    printf("\nEnter size of set 2: ");
    scanf("%d", &q);
    printf("Enter elements of set 2: ");
    for (i = 0; i < q; i++) {
	    scanf("%d", &x);
        if (pos(x) != -1)  
            b[pos(x)] = 1;
    }

    printf("\nSet 1: ");
    displaySet(a);
    printf("Set 2: ");
    displaySet(b);

    printf("\nUniversal set: ");
    display(u);
    printf("\nSet 1 bit string: ");
    display(a);
    printf("\nSet 2 bit string: ");
    display(b);

    setunion();
    intersect();
    setdiff();

    return 0;
}
