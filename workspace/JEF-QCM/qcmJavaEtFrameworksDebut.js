
// https://github.com/jewlofthelotus/SlickQuiz
qcmLabel["qcmJavaEtFrameworksDebut"] = "Début de la formation Java et frameworks";
qcm["qcmJavaEtFrameworksDebut"] = {
    "info": {
        "name":    "Quiz de début de la formation Java et frameworks",
        "main":    "<p>Avez-vous toutes les clefs en main pour profiter pleinement de cette formation ?</p>",
        "results": "<h5>En avant</h5><p>Quel que soit votre score, la formation va maintenant pleinement débuter. En cas de difficultés, n'hésitez pas à poser une question au formateur durant sa présentation</p>",
        "level1":  "expert en devenir",
        "level2":  "super développeur",
        "level3":  "développeur confirmé",
        "level4":  "développeur junior",
        "level5":  "développeur en devenir"
    },
    "questions": [
		{
            "q": "Java est un langage",
            "a": [
                {"option": "uniquement compilé",  "correct": false},
                {"option": "uniquement interprété",  "correct": false},
                {"option": "compilé et interprété",  "correct": true},
                {"option": "ni compilé, ni interprété",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Java est un langage initialement développé par",
            "a": [
                {"option": "Hewlett-Packard",  "correct": false},
                {"option": "Sun Microsystems",  "correct": true},
                {"option": "Microsoft",  "correct": false},
                {"option": "Oracle",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> Sun est bien l'éditeur historique de Java puis Sun Microsystems a été racheté par Oracle.</p>",
            "incorrect": "<p><span>Perdu</span> Sun est l'éditeur historique de Java puis Sun Microsystems a été racheté par Oracle.</p>"
        },
		{
            "q": "Sélectionner la(es) vérité(s)",
            "a": [
                {"option": "Une classe peut implémenter plusieurs interfaces",  "correct": true},
				{"option": "Une classe peut implémenter une interface",  "correct": true},
                {"option": "Une classe peut étendre une classe",  "correct": true},
				{"option": "Une classe peut étendre plusieurs classes",  "correct": false},
                {"option": "Une classe peut implémenter plusieurs classes ",  "correct": false},
                {"option": "Une classe peut étendre une seule interface",  "correct": false},
                {"option": "Une classe peut étendre plusieurs interfaces",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Une classe peut en étendre une autre (et une seule) et peut implémenter plusieurs interfaces</p>"
        },
		{
            "q": "Sélectionner la(es) vérité(s)",
            "a": [
                {"option": "Une interface peut étendre une interface",  "correct": true},
                {"option": "Une interface peut étendre plusieurs interfaces",  "correct": true},
                {"option": "Une interface peut implémenter une interface",  "correct": false},
                {"option": "Une interface peut étendre une classe",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Une interface décrit des signatures de méthodes. Donc elle n'implémente rien mais elle peut étendre une autre interface.</p>"
        },
		{
            "q": "Une interface peut contenir :",
            "a": [
                {"option": "des méthodes publiques",  "correct": true},
                {"option": "des méthodes statiques",  "correct": false},
                {"option": "des méthodes privées",  "correct": false},
                {"option": "des constantes publiques",  "correct": true},
                {"option": "des constantes privées",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Une interface définit la liste des méthodes exposées par un composant. Donc des méthodes publiques et des constantes publiques</p>"
        },
		{
            "q": "<img src='./ressourcesQuiz/umlAB.png' style='width:200px; float:left'/><br/>Soit la classe B qui hérite de A (B extends A), sélectionner la(es) ligne(s) valide(s)",
            "a": [
                {"option": "A monObjet = new A();",  "correct": true},
                {"option": "A monObjet = new B();",  "correct": true},
                {"option": "B monObjet = new A();",  "correct": false},
                {"option": "A a = new A(); B b = a;",  "correct": false},
                {"option": "B b = new B(); A a = b;",  "correct": true}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quels sont les caractères pour définir des commentaires dans le code",
            "a": [
                {"option": "-- mon commentaire",  "correct": false},
				{"option": "# mon commentaire",  "correct": false},
                {"option": "// mon commentaire",  "correct": true},
                {"option": "// mon commentaire multiligne",  "correct": false},
                {"option": "/* mon commentaire multiligne */",  "correct": true},
				{"option": "/** mon commentaire multiligne */",  "correct": true},
				{"option": "/* mon commentaire monoligne */",  "correct": true}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quels sont les mots-clefs de Java ?",
            "a": [
                {"option": "public",  "correct": true},
                {"option": "private",  "correct": true},
                {"option": "protected",  "correct": true},
                {"option": "transient",  "correct": true},
                {"option": "static",  "correct": true},
                {"option": "final",  "correct": true},
                {"option": "class",  "correct": true},
				{"option": "interface",  "correct": true},
                {"option": "implements",  "correct": true},
				{"option": "new",  "correct": true},
                {"option": "extends",  "correct": true},
                {"option": "throw",  "correct": true},
                {"option": "throws",  "correct": true},
				{"option": "now",  "correct": false},
				{"option": "select",  "correct": false},
                {"option": "update",  "correct": false},
                {"option": "delete",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quels sont les mots-clefs de Java ?",
            "a": [
                {"option": "void",  "correct": true},
                {"option": "instanceof",  "correct": true},
                {"option": "for",  "correct": true},
                {"option": "while",  "correct": true},
                {"option": "do",  "correct": true},
                {"option": "if",  "correct": true},
                {"option": "else",  "correct": true},
                {"option": "elseif",  "correct": false},
                {"option": "elif",  "correct": false},
                {"option": "then",  "correct": false}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quelles sont les lignes valides ?",
            "a": [
                {"option": "int i = 0;",  "correct": true},
                {"option": "float f = 0;",  "correct": true},
				{"option": "float f = 0F;",  "correct": true},
                {"option": "double d = 0;",  "correct": true},
                {"option": "short s = 0;",  "correct": true},
                {"option": "short s = 0S;",  "correct": false},
                {"option": "float f = 35.4F;",  "correct": true},
				{"option": "float f = 35.4;",  "correct": false},
                {"option": "double d = 35.4;",  "correct": true},
				{"option": "double d = 35.4D;",  "correct": true}
            ],
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Par défaut, un nombre à décimal est un DOUBLE. Le caractère F est nécessaire pour créer un float. Le caractère D est optionnel.</p>"
        },
		{
            "q": "Le caractère \\n est un caractère valide",
            "a": [
                {"option": "oui",  "correct": true},
                {"option": "non",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span></p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Comment déclarer une constante publique dans une classe ?",
            "a": [
                {"option": "private const String MA_CONSTANTE = \"MA_VALEUR\"",  "correct": false},
                {"option": "public static String MA_CONSTANTE = \"MA_VALEUR\"",  "correct": false},
                {"option": "public static final String MA_CONSTANTE = \"MA_VALEUR\"",  "correct": true},
                {"option": "public static String MA_CONSTANTE == \"MA_VALEUR\"",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Que signifie le mot clef <b>static</b>",
            "a": [
                {"option": "que l'attribut n'est pas modifiable",  "correct": false},
                {"option": "que l'attribut est visible de toutes les classes du package",  "correct": false},
                {"option": "que l'attribut est un attribut de classe et non d'objet",  "correct": true},
                {"option": "que l'attribut ne sera pas pris en compte dans la serialization",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Que signifie le mot clef <b>final</b>",
            "a": [
                {"option": "que l'attribut n'est pas modifiable",  "correct": true},
                {"option": "que l'attribut est visible de toutes les classes du package",  "correct": false},
                {"option": "que l'attribut est un attribut de classe et non d'objet",  "correct": false},
                {"option": "que l'attribut ne sera pas pris en compte dans la serialization",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Que signifie le mot clef <b>protected</b>",
            "a": [
                {"option": "que l'attribut n'est pas modifiable",  "correct": false},
                {"option": "que l'attribut est visible de toutes les classes du package",  "correct": true},
                {"option": "que l'attribut est un attribut de classe et non d'objet",  "correct": false},
                {"option": "que l'attribut ne sera pas pris en compte dans la serialization",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Qu'implique un attribut déclaré sans aucune visibilité (ni protected, ni public, ni private)",
            "a": [
                {"option": "que l'attribut n'est pas modifiable",  "correct": false},
                {"option": "que l'attribut est visible de toutes les classes du package",  "correct": true},
                {"option": "que l'attribut est un attribut de classe et non d'objet",  "correct": false},
                {"option": "que l'attribut ne sera pas pris en compte dans la serialization",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Que signifie le mot clef <b>transient</b>",
            "a": [
                {"option": "que l'attribut n'est pas modifiable",  "correct": false},
                {"option": "que l'attribut est visible de toutes les classes du package",  "correct": false},
                {"option": "que l'attribut est un attribut de classe et non d'objet",  "correct": false},
                {"option": "que l'attribut ne sera pas pris en compte dans la serialization",  "correct": true}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
        /*
		{
            "q": "",
            "a": [
                {"option": "",  "correct": true},
                {"option": "",  "correct": true},
                {"option": "",  "correct": true},
                {"option": "",  "correct": true}
            ],
			"select_any": true,
			"force_checkbox": true,
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		*/
		{
            "q": "Avez-vous des questions à proposer pour enrichir ce quiz ??",
            "a": [
                {"option": "oui",  "correct": true},
                {"option": "non",  "correct": true}
            ],
			"select_any": true,
            "correct": "<p><span>N'hésitez pas à poser des questions sur le contenu de ce quiz une fois que tout le monde aura terminé !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        }
    ]
};
