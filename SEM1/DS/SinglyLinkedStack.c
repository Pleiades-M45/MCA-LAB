#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node* next;
};
struct node* top=NULL, *ptr = NULL, *temp = NULL;

void push(){
    int item;
    ptr = (struct node*)malloc(sizeof(struct node));
    printf("Enter the value to be pushed: ");
    scanf("%d",&item);

    ptr->data = item;
    ptr->next = top;
    top = ptr;

    printf("%d inserted successfully\n",item);
}
void pop(){
    temp = top;

    if(top == NULL){
        printf("List is empty\n");
        return;
    }

    top = top->next;
    printf("%d deleted\n",temp->data);
    free(temp);

}
void display(){
    temp = top;
    if(top == NULL){
        printf("List is empty\n");
        return;
    }

    while(temp!=NULL){
        printf("%d\t",temp->data);
        temp = temp->next;
    }
}
int main()
{
    int ch;
    while(1){
        printf("\n1.Push\n2.Pop\n3.Display\n4.Exit\n\nEnter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1:push(); break;
            case 2:pop(); break;
            case 3:display(); break;
            case 4:exit(0);
            default:printf("Invalid Choice\n");
        }
    }
    return 0;
}