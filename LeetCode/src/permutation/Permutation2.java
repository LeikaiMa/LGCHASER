package permutation;

//* 从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，
//* 从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例：
//* 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
//* 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
//* 固定c，求后面ba的排列：cba，cab。
//* 
//* 即递归树：
//　　　　　str:　　 a 　　　　 b	　　　　　　	 c
//　　　　　　　　ab ac	　　	 ba bc	　　　　	 ca cb
//　　result:	 abc acb	　　 bac bca　     　 cab cba

public class Permutation2 {
	public static void permuation1(String str ,String result ,int len){
        /* 全排列 递归实现 
      递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */
        
          //结果 开始传入""   空字符进入   len   是这个数的长度
          if(result.length()==len){            //表示遍历完了一个全排列结果
           System.out.println(result);
          }
          else{
              for(int i=0;i<str.length();i++){
                  if(result.indexOf(str.charAt(i))<0){    //返回指定字符在此字符串中第一次出现处的索引。
                      //System.out.println("字母："+str.charAt(i));
                      permuation1(str, result+str.charAt(i), len);
                  }
              } 
          }
    }
	
	public static void main(String args[]) throws Exception { 
        String s = "abc";
        String result = "";
        permuation1(s, result, s.length());
   } 
}
