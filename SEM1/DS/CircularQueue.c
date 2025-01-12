#include<stdio.h>
#include<stdlib.h>
int q[20], front = -1, rear = -1, n;

void insert(){
    int item;
    if((rear+1)%n == front){
        printf("Queue is full\n");
        return;
    }

    printf("Enter the item to be inserted: ");
    scanf("%d",&item);

    if(front == -1){
        front = 0;
    }
    rear = (rear+1)%n;
    q[rear] = item;

    printf("%d inserted successfully\n",item);
}

void delete(){
    int item;
    if(front == -1){
        printf("Queue is empty\n");
        return;
    }

    item = q[front];
    if(front == rear){
        front = rear = -1;
    }
    else{
        front = (front+1)%n;
    }
    printf("%d deleted\n",item);
}

void display(){
    int i;
    if(front == -1){
        printf("Queue is empty\n");
        return;
    }

    if(front <= rear){
        for(i = front;i <= rear;i++){
            printf("%d\t",q[i]);
        }
    }
    else{
        for(i = front;i < n;i++){
            printf("%d\t",q[i]);
        }
        for(i = 0;i <= rear;i++){
            printf("%d\t",q[i]);
        }
    }
}

void search() {
    int item, i, pos = -1;
    if (front == -1) {
        printf("Queue is empty\n");
        return;
    }

    printf("Enter the item to search: ");
    scanf("%d", &item);

    if (front <= rear) {
        for (i = front; i <= rear; i++) {
            if (q[i] == item) {
                pos = i;
                break;
            }
        }
    } else {
        for (i = front; i < n; i++) {
            if (q[i] == item) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            for (i = 0; i <= rear; i++) {
                if (q[i] == item) {
                    pos = i;
                    break;
                }
            }
        }
    }

    if (pos != -1) {
        printf("Item %d found at position %d\n", item, pos+1);
    } else {
        printf("Item %d not found in the queue\n", item);
    }
}

int main(){
    int ch;
    printf("Enter the size of the Queue: ");
    scanf("%d",&n);
    while(1){
        printf("\n1.Insertion\n2.Deletion\n3.Display\n4.Search\n5.Exit\n\nEnter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1:insert(); break;
            case 2:delete(); break;
            case 3:display(); break;
            case 4:search(); break;
            case 5:exit(0);
            default:printf("Invalid Choice\n");
        }
    }
    return 0;
}