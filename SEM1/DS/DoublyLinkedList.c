#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *start = NULL, *temp = NULL, *ptr = NULL;

void insert() {
    int item, pos;
    printf("Enter item to insert: ");
    scanf("%d", &item);
    printf("Enter position: ");
    scanf("%d", &pos);

    ptr = (struct node *)malloc(sizeof(struct node));
    if (!ptr) {
        printf("Memory allocation failed\n");
        return;
    }
    ptr->data = item;
    ptr->prev = NULL;
    ptr->next = NULL;

    if (pos == 1) {
        if (start == NULL) {
            start = ptr;
        } else {
            ptr->next = start;
            start->prev = ptr;
            start = ptr;
        }
    } else {
        temp = start;
        int i;
        for (i = 1; i < pos - 1 && temp != NULL; i++) {
            temp = temp->next;
        }
        if (temp == NULL) {
            printf("Position out of range\n");
            free(ptr);  // Free memory if position is invalid
            return;
        }
        ptr->next = temp->next;
        ptr->prev = temp;
        if (temp->next != NULL) {
            temp->next->prev = ptr;
        }
        temp->next = ptr;  // Insert in the middle or at the end
    }
}

void deletion() {
    int pos;
    if (start == NULL) {
        printf("Empty list\n");
        return;
    }

    printf("Enter position to delete: ");
    scanf("%d", &pos);

    temp = start;
    int i;
    for (i = 1; temp != NULL && i < pos; i++) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Invalid position\n");
        return;
    }

    if (temp == start) {
        start = temp->next;  // Move start if the first element is deleted
        if (start != NULL) {
            start->prev = NULL;
        }
    } else {
        if (temp->prev != NULL) {
            temp->prev->next = temp->next;
        }
        if (temp->next != NULL) {
            temp->next->prev = temp->prev;
        }
    }

    printf("%d deleted\n", temp->data);
    free(temp);
}

void mini() {
    if (start == NULL) {
        printf("Empty list\n");
        return;
    }

    temp = start;
    int minimum = temp->data;
    while (temp != NULL) {
        if (temp->data < minimum) {
            minimum = temp->data;
        }
        temp = temp->next;
    }
    printf("Minimum = %d\n", minimum);
}

void display() {
    if (start == NULL) {
        printf("Empty list\n");
        return;
    }

    temp = start;
    while (temp != NULL) {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    int ch;

    while (1) {
        printf("\n1. Insert\n2. Delete\n3. Display\n4. Minimum\n5. Exit\nEnter choice: ");
        scanf("%d", &ch);

        switch (ch) {
            case 1: insert();
                    break;
                
            case 2: deletion();
                    break;
                
            case 3: display();
                break;

            case 4: mini();
                    break;   

            case 5: return 0;  

            default: printf("Invalid choice. Try again.\n");      
        }
    }
}