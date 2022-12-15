public class MainTest {
    public static void main(String[] args) throws Exception {
        Queue cola = new Queue(5);

        cola.push(2);
        cola.push(5);
        cola.push(8);
        cola.push(1);
        cola.push(10);

        //System.out.println(cola.binarySearch(10));
        System.out.println(cola.linealSearch(10));
    }
}
