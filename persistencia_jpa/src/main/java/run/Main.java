package run;

import entities.Autor;
import entities.Categoria;
import entities.Libro;
import services.dao.MyDao;
import services.interfaces.ICRUD;
import java.util.List;

public class Main {

    public static final ICRUD dao = new MyDao();

    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicana");
        dao.insert(a);

        Autor r = new Autor();
        r.setNombre("Ruben Dario");
        r.setNacionalidad("Nicaraguense");
        dao.insert(r);
    }

    public static void listarAutores() {
        System.out.println("Registro Almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor() {
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        a.setNacionalidad("Colombiana");
        dao.update(a);
    }

    // Categoria
    public static void insertarCategoria() {
        Categoria c1 = new Categoria();
        c1.setNombre("Novela");
        dao.insert(c1);

        Categoria c2 = new Categoria();
        c2.setNombre("Poesía");
        dao.insert(c2);
    }

    public static void listarCategorias() {
        System.out.println("Registros Almacenados (Categorías):");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(c -> System.out.println(c.getNombre()));
    }

    public static void editarCategoria() {
        Categoria c = new Categoria();
        c = dao.findById(1, Categoria.class);
        c.setNombre("Narrativa");
        dao.update(c);
    }

    public static void eliminarCategoria() {
        Categoria c = new Categoria();
        c = dao.findById(2, Categoria.class);
        dao.delete(c);
    }

    // Libro
    public static void insertarLibro() {
        Autor a1 = dao.findById(1, Autor.class);
        Categoria cat1 = dao.findById(1, Categoria.class);

        Libro l1 = new Libro();
        l1.setTitulo("Cien años de soledad");
        l1.setAñoPub(1967);
        l1.setAutor(a1);
        l1.setCategoria(cat1);
        dao.insert(l1);

        Autor a2 = dao.findById(2, Autor.class);
        Categoria cat2 = dao.findById(2, Categoria.class);

        Libro l2 = new Libro();
        l2.setTitulo("Azul...");
        l2.setAñoPub(1888);
        l2.setAutor(a2);
        l2.setCategoria(cat2);
        dao.insert(l2);
    }

    public static void listarLibros() {
        System.out.println("Registros Almacenados (Libros):");
        List<Libro> libros = dao.getAll("libros", Libro.class);
        libros.forEach(l -> System.out.println(l.getTitulo()));
    }

    public static void editarLibro() {
        Libro l = new Libro();
        l = dao.findById(1, Libro.class);
        l.setTitulo("Cien años de soledad (Edición revisada)");
        l.setAñoPub(1968);
        dao.update(l);
    }

    public static void eliminarLibro() {
        Libro l = new Libro();
        l = dao.findById(2, Libro.class);
        dao.delete(l);
    }

    public static void eliminarAutor() {
        Autor a = new Autor();
        a = dao.findById(2, Autor.class);
        dao.delete(a);
    }

    public static void main(String[] args) {
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();

        // Categoria
        insertarCategoria();
        listarCategorias();
        editarCategoria();
        listarCategorias();
        eliminarCategoria();
        listarCategorias();

        // Libro
        insertarLibro();
        listarLibros();
        editarLibro();
        listarLibros();
        eliminarLibro();
        listarLibros();
    }
}