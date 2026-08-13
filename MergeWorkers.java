public class MergeWorkers {
    int workers(int n){
        if(n==2||n==1){
            return 1;
        }
        int first , second;
        first=(int)Math.ceil(n/2);
        second=(int)Math.floor(n/2);

        return 1 + workers(first)+workers(second);
    }
}