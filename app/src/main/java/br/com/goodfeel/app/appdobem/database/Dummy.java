package br.com.goodfeel.app.appdobem.database;

import android.database.sqlite.SQLiteDatabase;

public class Dummy {

    //Quote TABLE
    private static final String QUOTE_TABLE = "Quotes";
    private static final String _ID_QUOTE = "_Id_Quote";
    private static final String _ID_AUTHOR_QUOTE = "_Id_Author";
    private static final String CONTENT = "Content";

    //Quote AUTHOR
    private static final String AUTHOR_TABLE = "Authors";
    private static final String _ID_AUTHOR = "_Id_Author";
    private static final String PICTURE = "Picture";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String DESCRIPTION = "Description";
    private static final String BIRTH_DATE = "BirthDate";
    private static final String DEATH_DATE = "DeathDate";

    private SQLiteDatabase db;

    public void author() {
        db.execSQL("INSERT INTO " + AUTHOR_TABLE + "(" + PICTURE + "," + FIRST_NAME + "," + LAST_NAME + "," + DESCRIPTION + "," + BIRTH_DATE + "," + DEATH_DATE + ") VALUES ('https://www.companhiadasletras.com.br/images/autores/03964_gg.jpg', 'Tati', 'Bernarde', 'Tati Bernardi, como é mais conhecida, nasceu em 1979 em São Paulo e formou-se em Propaganda e Marketing pela Universidade Mackenzie. Além da publicidade, Tati também dedica-se a literatura, já tendo quatro livros publicados, sendo os mais conhecidos: \"A mulher que não prestava\" e \"Tô com vontade de alguma coisa que eu não sei o que é\". Tati Bernardi consagrou-se com seu site, onde a maior parte do público são mulheres. Além disto, Tati também é colunista e cronista de revistas, como a Viagem & Turismo, blogueira e redatora da TV Globo. Além disto, fez cursos de pós-graduação na área de roteiro e cinema, e trabalhou muitos anos como redatora publicitária nas principais agências de propaganda de São Paulo, tais como W/Brasil, Talent, Leo Burnett e AgênciaClick.', '', '')");
        db.execSQL("INSERT INTO " + AUTHOR_TABLE + "(" + PICTURE + "," + FIRST_NAME + "," + LAST_NAME + "," + DESCRIPTION + "," + BIRTH_DATE + "," + DEATH_DATE + ") VALUES ('https://upload.wikimedia.org/wikipedia/pt/8/8e/C_S_Lewis.jpg', 'Clive', 'Staples Lewis', 'Clive Staples Lewis (1898-1963), mais conhecido como C.S. Lewis, foi um escritor irlandês, que se destacou por seus trabalhos sobre literatura medieval, por suas palestras e escritos cristãos, especialmente a série de livros \"As Crônicas de Nárnia\". C.S. Lewis nasceu em Belfast, na Irlanda, no dia 29 de novembro de 1898. Em 1916 foi admitido na University College de Oxford. Entre 1917 e 1918 serviu nos campos de batalha da França durante a Primeira Guerra. De volta a Oxford se graduou em Línguas e Literaturas Clássicas. Lecionou nas universidades de Oxford e de Cambridge C. S. Lewis foi ateu durante muitos tempo, mas com 31 anos converteu-se ao cristianismo e se tornou membro da Igreja Anglicana. Durante a II Guerra Mundial, suas palestras eram transmitidas pela BBC de Londres, sendo chamado \"apóstolo dos céticos\", especialmente nos Estados Unidos. A religião foi um tema constante em suas obras, como em “Cartas de Um Diabo ao Seu Aprendiz” (1942), “Milagre” (1947), e nos sete livros da série “As Crônicas de Nárnia” (1950-1956), que virou filme do Walt Disney Studios. C.S. Lewis faleceu em Oxford, Inglaterra, no dia 22 de novembro de 1963.', '', '')");
        db.execSQL("INSERT INTO " + AUTHOR_TABLE + "(" + PICTURE + "," + FIRST_NAME + "," + LAST_NAME + "," + DESCRIPTION + "," + BIRTH_DATE + "," + DEATH_DATE + ") VALUES ('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThDJWMPQmcd-ZZkCyD2ickef6OQj5w5qadqX7Vx7mCygXzmWXg', 'Dale', 'Carnegie', 'Dale Carnegie nasceu em Maryville, Missouri, Estados Unidos, no dia 24 de novembro de 1888. Filho de fazendeiros, ainda jovem ajudava nas tarefas da fazenda, mas não deixou de estudar. Formou-se na Faculdade do Estado de Warrensburg, no Missouri. Depois de formado, trabalhou como vendedor de cursos, por correspondência, para pecuaristas. Empregou-se como vendedor na Armor & Company, uma empresa de empacotamento de carne. Em 1912 começou a ministrar um treinamento na arte de falar em público. Ingressou na Academia de Artes Dramáticas, para vencer a timidez. Começou trabalhando como ator, e rapidamente se tornou bem sucedido em suas palestras. Em 1913 lançou seu primeiro livro, que virou um best-seller: “Falar em Público e Influenciar Homens de Negócios”. Em 1919, ele mudou seu nome de Carnegey para Carnegie. Em 1926, ele publicou a primeira coleção de seus estudos, intitulado “Falar em Público: Um Curso Prático Para Homens de Negócios”. O livro foi mais um best-seller do autor. Em 1936 publicou “Como Fazer Amigos e Influenciar Pessoas” que continua popular até hoje. Seus livros foram traduzidos em diversos idiomas. A “Dale Carnegie Course” é hoje uma organização multinacional que se tornou líder em treinamentos empresariais. Dale Carnegie faleceu em Forest Hills, Nova York, Estados Unidos, no dia 1 de novembro de 1955.', '', '')");
    }

    public void quotes() {
        db.execSQL("INSERT INTO " + QUOTE_TABLE + "(" + _ID_AUTHOR_QUOTE + "," + CONTENT + ") VALUES (1, '')");
    }
}
