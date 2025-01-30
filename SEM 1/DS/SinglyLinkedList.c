#include <stdio.h>
#include <stdlib.h>

int count = 0;

struct node
{
    int data;
    struct node *next;
};

struct node *start = NULL;

void create()
{
    int n, item, i = 0;
    struct node *ptr, *temp;

    if (count == 0)
    {
        printf("\nEnter the number of nodes to be inserted : ");
        if (scanf("%d", &n) != 1 || n <= 0)
        {
            printf("\nInvalid input. Please enter a positive integer.\n");
            return;
        }

        while (i < n)
        {
            printf("\nEnter value to insert: ");
            scanf("%d", &item);

            ptr = (struct node *)malloc(sizeof(struct node));
            if (ptr == NULL)
            {
                printf("\nMemory allocation failed\n");
                return;
            }

            ptr->data = item;
            ptr->next = NULL;

            if (count == 0)
            {
                start = ptr;
                temp = start;
            }
            else
            {
                temp->next = ptr;
                temp = temp->next;
            }
            count++;
            i++;
        }
    }
    else
        printf("\nList already created\n");
}

void insert_begin()
{
    int item;
    struct node *ptr;

    printf("\nEnter value to insert : ");
    scanf("%d", &item);

    ptr = (struct node *)malloc(sizeof(struct node));
    if (ptr == NULL)
    {
        printf("\nMemory allocation failed\n");
        return;
    }

    ptr->data = item;
    ptr->next = start; // Link new node to current start
    start = ptr;       // Update start to new node

    count++;

    printf("\n\t%d successfully inserted at the beginning\n", item);
}

void insert_end()
{
    struct node *ptr, *temp;
    int item;

    printf("\nEnter value to insert : ");
    scanf("%d", &item);

    ptr = (struct node *)malloc(sizeof(struct node));
    if (ptr == NULL)
    {
        printf("\nMemory allocation failed\n");
        return;
    }

    ptr->data = item;
    ptr->next = NULL;  // New node will be the last node

    if (start == NULL)
    {
        start = ptr; // List is empty
    }
    else
    {
        temp = start;
        while (temp->next != NULL)
        {
            temp = temp->next;   // Move to the end of the list
        }

        temp->next = ptr; // Link last node to new node
    }

    count++;
    printf("\n\t%d successfully inserted at the end\n", item);
}

void insert_pos()
{
    int item, pos, i;
    struct node *ptr, *temp;

    printf("\nEnter value to insert : ");
    scanf("%d", &item);
    printf("\nEnter position : ");
    scanf("%d", &pos);

    if (pos < 1)
    {
        printf("\n\tInvalid position\n");
        return;
    }

    ptr = (struct node *)malloc(sizeof(struct node));
    if (ptr == NULL)
    {
        printf("\nMemory allocation failed\n");
        return;
    }

    ptr->data = item;

    if (pos == 1)
    {
        ptr->next = start;
        start = ptr;
        count++;
        printf("\n%d inserted at position 1\n", item);
        return;
    }

    temp = start;
    for (i = 1; i < pos - 1 && temp != NULL; i++)
    {
        temp = temp->next;
    }

    if (temp == NULL) //  position greater than list length || empty list and position greater than 1
    {
        printf("\n\tInsertion not possible: Position out of bounds\n");
        free(ptr);
    }
    else
    {
        ptr->next = temp->next;
        temp->next = ptr;
        count++;
        printf("\n\t%d successfully inserted at position %d\n", item, pos);
    }
}

void delete_begin() 
{
    int x;
    struct node *temp;

    if (start == NULL) 
    {
        printf("\nList is empty\n");
    } 
    else 
    {
        temp = start;
        start = temp->next;
        x=temp->data;
        free(temp);
        count--;
        printf("\n%d deleted\n",x);
    }
}

void delete_end() 
{
    int x;
    struct node *temp, *ptr;

    if (start == NULL) 
    {
        printf("\nList is empty\n");
    } 
    else if (start->next == NULL)    // only one element
    {
        x=start->data;
        free(start);
        start = NULL;
        count--;
        printf("\n%d deleted\n",x);
    } 
    else 
    {
        temp = start;
        while (temp->next->next != NULL) 
        {
            temp = temp->next;
        }

        ptr = temp->next;
        temp->next = NULL;
        x=ptr->data;
        free(ptr);
        count--;
        printf("\n%d deleted\n",x);
    }
}

void delete_pos() 
{
    struct node *ptr, *temp;
    int pos, i,x;
    
    if (start == NULL) 
    {
        printf("\nList is empty\n");
        return;
    }

    printf("\nEnter position: ");
    scanf("%d", &pos);
    if (pos < 1)
    {
        printf("\n\tInvalid position\n");
        return;
    }

    if (pos == 1) 
    {
        temp = start;
        start = temp->next;
        x=temp->data;
        free(temp);
        count--;
        printf("\n%d deleted\n",x);
        return;
    }

    temp = start;
    for (i = 1; i < pos - 1 && temp != NULL; i++) 
    {
        temp = temp->next;
    }

    if (temp == NULL || temp->next == NULL) 
    {
        printf("\nDeletion not possible: Position out of bounds\n");
    } 
    else 
    {
        ptr = temp->next;
        temp->next = ptr->next;
        x=ptr->data;
        free(ptr);
        count--;
        printf("\n%d deleted\n",x);   
    } 
}

void search()
{
    struct node *ptr;
    int item, i = 0, found = 0;

    ptr = start;

    if (ptr == NULL)
    {
        printf("\nEmpty list\n");
    }
    else
    {
        printf("\nEnter element to be searched: ");
        if (scanf("%d", &item) != 1)       // Input validation for item
        { 
            printf("\nInvalid input. Please enter an integer.\n");
            while (getchar() != '\n');     // Clear invalid input
            return;
        }

        while (ptr != NULL)
        {
            if (ptr->data == item)
            {
                printf("\n%d found at position %d\n", ptr->data, i + 1);
                found = 1;
                break;
            }
            ptr = ptr->next;
            i++;
        }
        if (!found)
        {
            printf("\n%d not found\n", item);
        }
    }
}

void display()
{
    struct node *ptr;

    ptr = start;

    if (ptr == NULL)
    {
        printf("\nList is empty\n");
    }
    else
    {
        printf("\n\tList\n\n");

        while (ptr != NULL)
        {
            printf("%d\t", ptr->data);
            ptr = ptr->next;
        }
        printf("\n");
    }
}

void free_list()
{
    struct node *temp;
    while (start != NULL)
    {
        temp = start;
        start = start->next;
        free(temp);
    }
}

int main()
{
    int choice;
    while (1)
    {
        printf("\n------------------------------\n");
        printf("\n1. Creation\n2. Insert Beginning\n3. Insert End\n4. Insert Position\n5. Delete Beginning\n6. Delete End\n7. Delete Position\n8. Search\n9. Display\n10. Exit\n");
        printf("\n------------------------------\n");

        printf("\nEnter your choice : ");
        if (scanf("%d", &choice) != 1)          // Input validation for choice
        { 
            printf("\nInvalid input. Please enter a number.\n");
            while (getchar() != '\n');          // Clear invalid input
            continue;
        }

        switch (choice)
        {
            case 1: create(); break;
            case 2: insert_begin(); break;
            case 3: insert_end(); break;
            case 4: insert_pos(); break;
            case 5: delete_begin(); break;
            case 6: delete_end(); break;
            case 7: delete_pos(); break;
            case 8: search(); break;
            case 9: display(); break;
            case 10: free_list(); exit(0);
            default: printf("\nInvalid choice\n");
        }
    }
    return 0;
}