
      function solution(A, B){
         let sol=0
         for(sol;sol<100;sol++){
            if(A==B){
               return(sol);break
            }
               else{A=A.slice(-1,)+A.slice(0,-1)}
         }
         if (sol==100){
            return(-1)
         }
          
      }