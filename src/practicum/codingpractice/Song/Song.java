package practicum.codingpractice.Song;

import java.util.Objects;

public class Song {
    public final String title;
    public final String artist;
    public final String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    // переопределите метод equals(Object)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // проверяем адреса объектов
        if (obj == null) return false; // проверяем ссылку на null
        if (this.getClass() != obj.getClass()) return false; // сравниваем классы
        Song otherBook = (Song) obj; // открываем доступ к полям другого объекта
        return Objects.equals(title, otherBook.title) && // проверяем все поля
                Objects.equals(artist, otherBook.artist) && // нужно логическое «и»
                (songwriter == otherBook.songwriter); // примитивы сравниваем через ==
    }

}