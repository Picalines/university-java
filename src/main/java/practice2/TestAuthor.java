package practice2;

public class TestAuthor {
    public static void main(String[] args) {
        var author = new Author("David", "david@mail.com", 'm');
        System.out.println(author);

        author.setEmail("newdavid@email.com");
        System.out.println(author);
    }
}
