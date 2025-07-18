import java.util.ArrayList;
/** ADT
 * เก็บเป็นจำนวนเต็ม จากน้อยไปมาก ไม่null ไม่ซ้ำ
 */
public class IntegerSet {
    ArrayList<Integer> Numbers; //Rap
    //AF เซตเลขที่อยู่ใน Number
    //RI เก็บเป็นจำนวนเต็ม จากน้อยไปมาก ไม่null ไม่ซ้ำ
    public IntegerSet(){
        Numbers = new ArrayList<>();
        CheckRep();
    }
    private void CheckRep(){
      if (Numbers == null ) {
            throw new RuntimeException("Numbers Must No Empty");
        }
        for (int i = 0; i < Numbers.size() - 1; i++) {
            if (Numbers.get(i)>=(Numbers.get(i + 1)) ) {
                throw new RuntimeException("Rep Invariant Violated!");
            }
        }
    }

    /**ไม่เป็นค่าว่าง รับเลขเข้าเซต
     * @param x เทิร์นเลขกลับ
     */
     public void add (Integer x){
        if (!Numbers.contains(x) && Numbers != null && x != null){
            if(Numbers.size()==0){
                Numbers.add(x);
            }else{
                for(int i=0; i<Numbers.size(); i++){
                    if(x<Numbers.get(0)){   //หน้า
                        Numbers.add(0,x);
                        break;
                    }
                    if(i==Numbers.size()-1){    //หลัง
                        Numbers.add(x);
                        break;
                    }
                    if(Numbers.get(i)<x && x<Numbers.get(i+1)){ //กลาง
                            Numbers.add(i+1,x);
                            break;
                    }
                }
            }
        }
        CheckRep();
    }

    /**
     * ออกเซต
     * @param x
     */
    public  void remove(Integer x) {
       if (x == null) 
        return;
        Numbers.remove(x);
        CheckRep();
    }
    /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในเซตหรือไม่
     * @param x ตัวเลขที่ต้องการตรวจสอบ
     * @return true หากมี xอยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer x){
        return Numbers.contains(x); //สร้างสำหรับเช็คการมีอยู่ของตัวอักษรผ่าน con โดยใส่numลงcon แล้วให้set(user)เรียกcon
    }
    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public int size() {
        return Numbers.size();
    }
      
    public String toString(){
        return Numbers.toString();
    }
}