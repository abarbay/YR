package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

    public class Library {

        public Book getFirstBook(List books) {
            Book firstBook;
            if(books==null){throw new NullPointerException();}
            if(books.size()==0){throw new IllegalArgumentException("Argument should not be empty");}
            try{
                firstBook=(Book)books.get(0);
            }catch (ClassCastException cce){
                throw new ClassCastException("Not a book");
            }


            return (Book)books.get(0);
        }

    }

