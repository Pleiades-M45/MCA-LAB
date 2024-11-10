<<<<<<< HEAD
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct node 
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *root = NULL,*temp=NULL;

struct node* create_node(int item)
{
    struct node* ptr = (struct node*)malloc(sizeof(struct node));
    ptr -> data = item;
    ptr -> left = NULL;
    ptr -> right = NULL;
    return ptr;
}

struct node* insert_node(struct node * root, int item)
{
    if (root == NULL)
    {
	printf("%d inserted\n",item);
	return create_node(item);
    }
    else if (item < root -> data) 
    {
       root -> left = insert_node(root -> left, item);
    }
    else
    {
        root -> right = insert_node(root -> right, item);
    }
    return root;
}

//function to find the minimum value node in a given tree
struct node* find_minimum(struct node * root)
{
    while (root->left != NULL)
    {
	root = root->left;
    }
  return root;
}

struct node* delete_node(struct node * root, int item)
{
  if (root == NULL)
  {
    printf("%d not found\n",item);
    return root;
  }
  if (item < root -> data)
    root -> left = delete_node(root -> left, item);
  else if (item > root -> data)
    root -> right = delete_node(root -> right, item);
  else 
  {
    //No Child node
    if (root -> left == NULL && root -> right == NULL) 
    {
      free(root);
      printf("%d deleted\n",item);
      return NULL;
    }

    //One Child node
    else if (root -> left == NULL || root -> right == NULL) 
    {
      struct node* temp = (root->left == NULL) ? root->right : root->left;
      free(root);
      printf("%d deleted\n",item);
      return temp;
    }

    //Two Children: Get the inorder successor (smallest in the right subtree)
      temp = find_minimum(root -> right);
      root -> data = temp -> data;
      root -> right = delete_node(root -> right, temp -> data);
  }
  return root;
}

void inorder(struct node *root) 
{
  if (root != NULL)
  {
    inorder(root -> left);
    printf("%d\t", root -> data); 
    inorder(root -> right);
  }
}

void preorder(struct node *root) 
{
  if (root != NULL)
  {
    printf("%d\t", root -> data); 
    preorder(root -> left);
    preorder(root -> right);
  }
}

void postorder(struct node *root) 
{
  if (root != NULL)
  {
    postorder(root -> left);
    postorder(root -> right);
    printf("%d\t", root -> data); 
  }
}

void main()
{
    int ch,item;
    clrscr();
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
        printf("\n");
        switch(ch)
        {
            case 1: printf("Enter item for new node: ");
                    scanf("%d", &item);
                    root = insert_node(root,item); 
                    break;
	    case 2: if(root == NULL) { printf("Empty tree\n"); }
		    else
		    {
		     printf("Enter the item to delete : ");
		     scanf("%d",&item);
		     root = delete_node(root,item);
		    }
		    break;
            case 3: if (root == NULL) {  printf("Tree is empty\n");  }
                    else {  inorder(root);  }
                    break;
            case 4: if (root == NULL) {  printf("Tree is empty\n");  }
                    else {  preorder(root);  }
                    break;
            case 5: if (root == NULL) {  printf("Tree is empty\n");  }
                    else {  postorder(root);  }
                    break;
            case 6: exit(0);
            default: printf("Invalid choice\n");
        }
    }
=======
#include <stdio.h>
#include <stdlib.h>

struct node 
{
    int data;
    struct node *left;
    struct node *right;
};

struct node *root = NULL;

struct node* create_node(int item)
{
    struct node* ptr = (struct node*)malloc(sizeof(struct node));
    ptr -> data = item;
    ptr -> left = NULL;
    ptr -> right = NULL;
    return ptr;
}

// // searching operation
// struct node* search(struct node * root, int x) {
//   if (root == NULL || root -> data == x) //if root->data is x then the element is found
//     return root;
//   else if (x < root -> data) 
//     return search(root -> left, x);
//   else 
//     return search(root -> right, x);
// }


struct node* insert_node(struct node * root, int item)
{
    if (root == NULL)
    {
        return create_node(item);
    }
    else if (item < root -> data) 
    {
       root -> left = insert_node(root -> left, item);
    }
    else
    {
        root -> right = insert_node(root -> right, item);
    }
    return root;
}

//function to find the minimum value node in a given tree
struct node* find_minimum(struct node * root) 
{
    while (root->left != NULL)
    {
        root = root->left;
    }
  return root;
}

struct node* delete_node(struct node * root, int item)
{
  if (root == NULL)
    return root;

  if (item < root -> data)
    root -> left = delete_node(root -> left, item);
  else if (item > root -> data)
    root -> right = delete_node(root -> right, item);
  else 
  {
    //No Child node
    if (root -> left == NULL && root -> right == NULL) 
    {
      free(root);
      return NULL;
    }

    //One Child node
    else if (root -> left == NULL || root -> right == NULL) 
    {
      struct node* temp = (root->left == NULL) ? root->right : root->left;
      free(root);
      return temp;
    }

    //Two Children: Get the inorder successor (smallest in the right subtree)
      struct node* temp = find_minimum(root -> right);
      root -> data = temp -> data;
      root -> right = delete_node(root -> right, temp -> data);
  }
  return root;
}

void inorder(struct node *root) 
{
  if (root != NULL)
  {
    inorder(root -> left);
    printf("%d\t", root -> data); 
    inorder(root -> right);
  }
}

void preorder(struct node *root) 
{
  if (root != NULL)
  {
    printf("%d\t", root -> data); 
    preorder(root -> left);
    preorder(root -> right);
  }
}

void postorder(struct node *root) 
{
  if (root != NULL)
  {
    postorder(root -> left);
    postorder(root -> right);
    printf("%d\t", root -> data); 
  }
}

void main()
{
    int ch,item;
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
        printf("\n");
        switch(ch)
        {
            case 1: printf("Enter item for new node: ");
                    scanf("%d", &item);
                    root = insert_node(root,item); 
                    break;
            case 2: printf("Enter the item to delete : ");
                    scanf("%d",&item);
                    root = delete_node(root,item); 
                    break;
            case 3: if (root == NULL) {  printf("Tree is empty\n");  }
                    else {  inorder(root);  }
                    break;
            case 4: if (root == NULL) {  printf("Tree is empty\n");  }
                    else {  preorder(root);  }
                    break;
            case 5: if (root == NULL) {  printf("Tree is empty\n");  }
                    else {  postorder(root);  }
                    break;
            case 6: exit(0);
            default: printf("Invalid choice\n");
        }
    }
>>>>>>> d0a4ba4dc7f43e81df76542e7ecf9136dec3aeda
}