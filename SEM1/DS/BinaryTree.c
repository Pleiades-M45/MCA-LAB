#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 25

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
};

// Global root declaration
struct Node* root = NULL;

struct Node* create(int item)
{
    struct Node* ptr = (struct Node*) malloc (sizeof(struct Node));  
    ptr->data = item;  
    ptr->left = NULL;
    ptr->right = NULL;
    return ptr;
}

void insert()
{
    int item;
    printf("Enter item for new node: ");
    scanf("%d", &item);
    struct Node* ptr = create(item);

    if(root == NULL)
    {
        root = ptr;
        printf("%d was inserted\n", item);
        return;
    }

    // Level-order insertion (using a queue)
    struct Node* queue[MAX_SIZE];
    int front = 0,rear = 0;
    queue[rear++] = root;
    while(front < rear)
    {
        struct Node* temp = queue[front++];
        if(temp->left != NULL)
        {
            queue[rear++] = temp->left;
        }
        else
        {
            temp->left = ptr;
            printf("%d was inserted\n", item);
            return;
        }
        if(temp->right != NULL)
        {
            queue[rear++] = temp->right;
        }
        else
        {
            temp->right = ptr;
            printf("%d was inserted\n", item);
            return;
        }
    }
}

void delete()
{
    int item;
    if(root == NULL)
    {
        printf("Empty Tree\n");
        return;
    }
    printf("Enter the item to delete : ");
    scanf("%d",&item);

    // Tree having only one node
    if(root->left == NULL && root->right == NULL)
    {
        if(root->data == item)
        {
            free(root);
            root = NULL;
            printf("%d was deleted\n", item);
            return;
        }
        else
        {
            printf("%d not present",item);
            return;
        }
    }

    // Level order traversal using the queue
    struct Node *temp = NULL, *last_node = NULL, *item_node = NULL;
    struct Node* queue[MAX_SIZE];
    int front = 0, rear = 0;
    queue[rear++] = root;

    // do level order traversal to find the deepest node
    while (front < rear)
    {
        temp = queue[front++];

        if (temp->data == item)
        {
            item_node = temp;
        }
        if (temp->left != NULL)
        {
            last_node = temp;
            queue[rear++] = temp->left;
        }
        if (temp->right != NULL)
        {
            last_node = temp;
            queue[rear++] = temp->right;
        }
    }

    // If item is found in the binary tree
    if (item_node != NULL)
    {
        item_node->data = temp->data; // Replace with the deepest node

        // Free the last node after updating its parent
        if (last_node->right == temp)
        {
            free(last_node->right);
            last_node->right = NULL;
        }
        else
        {
            free(last_node->left);
            last_node->left = NULL;
        }
        printf("%d was deleted\n", item);
        return;
    }
    printf("%d not found\n", item);
}   

void inorder(struct Node* root)
{
    if(root == NULL) return;
    inorder(root->left);
    printf("%d\t", root->data);
    inorder(root->right);
}

void preorder(struct Node* root)
{
    if(root == NULL) return;
    printf("%d\t", root->data);
    preorder(root->left);
    preorder(root->right);
}

void postorder(struct Node* root)
{
    if(root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    printf("%d\t", root->data);
}

int main()
{
    int ch;
    while(1)
    {
        printf("\n1. Insert ");
        printf("\n2. Delete");
        printf("\n3. Inorder Traversal");
        printf("\n4. Preorder Traversal");
        printf("\n5. Postorder Traversal");
        printf("\n6. Exit");
        printf("\nEnter Your Choice: ");
        scanf("%d", &ch);
        switch(ch)
        {
            case 1: insert(); break;
            case 2: delete(); break;
            case 3: inorder(root); break;
            case 4: preorder(root); break;
            case 5: postorder(root); break;
            case 6: exit(0);
            default: printf("Invalid choice\n");
        }
    }
    return 0;
}