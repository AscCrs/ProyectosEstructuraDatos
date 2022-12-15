public class MainTest {
    public static void main(String[] args) throws Exception {
        Queue cola = new Queue(10);

        cola.push(-3);
        cola.push(-10);
        cola.push(-5);
        cola.push(-7);
        cola.push(-2);
        cola.push(5);
        cola.push(9);
        cola.push(8);
        cola.push(22);
        cola.push(30);

        //System.out.println(cola.binarySearch(30));
        System.out.println(cola.linealSearch(30));
    }
}
