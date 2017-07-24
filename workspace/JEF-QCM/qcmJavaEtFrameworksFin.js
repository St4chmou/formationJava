
// https://github.com/jewlofthelotus/SlickQuiz
qcmLabel["qcmJavaEtFrameworksFin"] = "Fin de la formation Java et frameworks";
qcm["qcmJavaEtFrameworksFin"] = {
    "info": {
        "name":    "Quiz de fin de la formation Java et frameworks",
        "main":    "<p>Avez-vous retenu les éléments importants de cette formation ?</p>",
        "results": "<h5>Pas mal</h5><p>Quel que soit votre score, la formation n'est pas encore terminée. Vous pouvez encore poser des questions. <b>N'oubliez pas que le support de cours est disponible sur Face2Face (portal.corp.sopra)</b></p>",
        "level1":  "expert en devenir",
        "level2":  "super développeur",
        "level3":  "développeur confirmé",
        "level4":  "développeur junior",
        "level5":  "développeur en devenir"
    },
    "questions": [
		{
            "q": "Quelle(s) est(sont) la(es) particularité(s) d'une collection de type List",
            "a": [
                {"option": "La collection est toujours triée",  "correct": false},
                {"option": "La collection accepte les doublons",  "correct": true},
                {"option": "La collection lance une exception à l'ajout d'un doublon",  "correct": false},
				{"option": "La collection supprime les doublons et ne conserve qu'une instance",  "correct": false},
				{"option": "La collection permet de récupérer un élément par sa position",  "correct": true},
				{"option": "La collection permet de récupérer une valeur à partir d'une clef",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quelle(s) est(sont) la(es) particularité(s) d'une collection de type Set",
            "a": [
                {"option": "La collection est toujours triée",  "correct": false},
                {"option": "La collection accepte les doublons",  "correct": false},
                {"option": "La collection lance une exception à l'ajout d'un doublon",  "correct": false},
				{"option": "La collection supprime les doublons et ne conserve qu'une instance",  "correct": true},
				{"option": "La collection permet de récupérer un élément par sa position",  "correct": false},
				{"option": "La collection permet de récupérer une valeur à partir d'une clef",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quelle(s) est(sont) la(es) particularité(s) d'une Map",
            "a": [
                {"option": "La collection est toujours triée",  "correct": false},
                {"option": "La collection accepte les doublons",  "correct": false},
                {"option": "La collection lance une exception à l'ajout d'un doublon",  "correct": false},
				{"option": "La collection supprime les doublons et ne conserve qu'une instance",  "correct": false},
				{"option": "La collection permet de récupérer un élément par sa position",  "correct": false},
				{"option": "La collection permet de récupérer une valeur à partir d'une clef",  "correct": true}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Exposer les attributs d'une classe en public est une bonne pratique ?",
            "a": [
                {"option": "oui",  "correct": false},
                {"option": "non",  "correct": true}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quel est le nom donné aux méthodes permettant de lire et modifier un attribut privé ?",
            "a": [
                {"option": "ascenseur",  "correct": false},
                {"option": "accesseur",  "correct": true},
                {"option": "assesseur",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Un ascenseur monte et descend et un assesseur est une personne qui siège aux côtés d'une autre pour l'assister dans ses fonctions et la suppléer si nécessaire.</p>"
        },
		{
            "q": "Au nom de quel principe cache-t-on le contenu d'un composant et n'expose-t-on que le minimum aux autres composants du système ?",
            "a": [
                {"option": "couplage",  "correct": false},
                {"option": "cohérence",  "correct": false},
                {"option": "encapsulation",  "correct": true},
                {"option": "confusion",  "correct": false},
                {"option": "Thalès",  "correct": false},
                {"option": "Pythagore",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Sélectionner la(es) vérité(s) selon la norme Java standard",
            "a": [
                {"option": "Un nom de classe commence par une majuscule",  "correct": true},
                {"option": "Un nom d'attribut commence par une majuscule",  "correct": false},
                {"option": "Un nom d'attribut peut contenir un chiffre",  "correct": true},
                {"option": "Un nom d'attribut peut commencer par un chiffre",  "correct": false},
				{"option": "Un nom de constante se compose de majuscules séparées par des '_'",  "correct": true},
                {"option": "Un nom de classe utilise '_' pour séparer les mots",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Sélectionner la(es) vérité(s) sur les constructeurs",
            "a": [
                {"option": "Une classe doit obligatoirement contenir un constructeur codé",  "correct": false},
                {"option": "Un constructeur peut être privé",  "correct": true},
                {"option": "Un constructeur peut appeler un autre constructeur de la même classe",  "correct": true},
                {"option": "Un constructeur peut appeler un autre constructeur de la classe parente",  "correct": true},
                {"option": "Un constructeur doit avoir des paramètres",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Une classe peut contenir ...",
            "a": [
			    {"option": "... deux méthodes de même nom sans paramètres",  "correct": false},
			    {"option": "... deux méthodes de même nom sans paramètres retournant un objet de type différent",  "correct": false},
                {"option": "... deux méthodes de même nom avec un nombre différents de paramètres",  "correct": true},
                {"option": "... deux méthodes de même nom avec le même nombre de paramètres mais de types différents",  "correct": true},
                {"option": "... deux méthodes de même nom avec les mêmes paramètres mais une privée et l'autre publique",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> La signature comprend le nom de la méthode plus le type et l'ordre des paramètres. Deux signatures identiques n'est pas possible dans une même classe</p>"
        },
		{
            "q": "Une classe peut contenir le code d'une méthode ayant la même signature qu'une des méthodes de la classe dont elle hérite ?",
            "a": [
                {"option": "oui",  "correct": true},
                {"option": "non",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> C'est le principe de surcharge de méthode</p>"
        },
		{
            "q": "Maven et ses plugins permettent",
            "a": [
                {"option": "de lister les dépendances d'un JAR",  "correct": true},
                {"option": "d'identifier de manière unique un JAR",  "correct": true},
                {"option": "de compiler/tester/packager des JAR/WAR/EAR/ZIP",  "correct": true},
                {"option": "de sauvegarder dans un dépôt les artéfacts créés",  "correct": true},
                {"option": "de déployer une application sur un serveur WEB ou d'application",  "correct": true}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> En fait, Maven permet de faire énormément de choses dont celles citées. (Désolé pour le piège)</p>"
        },
		{
            "q": "Que signifie TDD ?",
            "a": [
                {"option": "Test Driven Development",  "correct": true},
                {"option": "Time Division Duplex",  "correct": false},
                {"option": "Time Driven Development",  "correct": false}
            ],
			"force_checkbox": true, 
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quel est le bon résumé de la pratique TDD ?",
            "a": [
                {"option": "Coder entièrement l'application puis coder l'ensemble des tests unitaires",  "correct": false},
                {"option": "Coder entièrement les tests unitaires puis coder l'ensemble de l'application",  "correct": false},
                {"option": "Coder un petit bout de tests unitaires puis coder le petit bout d'application correspondant",  "correct": true},
                {"option": "Coder un petit bout d'application puis coder le petit bout de tests unitaires correspondant",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "A quoi sert un test unitaire codé ? (plusieurs réponses possibles)",
            "a": [
                {"option": "Vérifier que le résultat de l'exécution d'un composant est bien celui attendu",  "correct": true},
                {"option": "Donner des exemples d'utilisation d'un composant",  "correct": true},
                {"option": "Documenter un composant sur son utilisation et les résultats escomptés en fonction de certains paramètres d'entrée",  "correct": true},
                {"option": "Ne plus faire de tests de qualification/recette interne",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Je crois que la qualification est encore nécessaire. Au minimum pour vérifier que les composants testés unitairement fonctionne bien quand ils communiquent entre eux (pour cela, il faut des tests d'intégration ou des tests applicatifs)</p>"
        },
		{
            "q": "Que doivent tester les tests unitaires ?",
            "a": [
                {"option": "Tous les cas nominaux",  "correct": false},
                {"option": "Tous les cas d'exception",  "correct": false},
                {"option": "Tous les cas alternatifs",  "correct": false},
				{"option": "Toutes les combinaisons de données possibles",  "correct": false},
                {"option": "Le test unitaire codé doit tester un maximum de cas mais dans les contraintes/règles édités par le projet",  "correct": true}
            ],
			"force_checkbox": true,			
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> La stratégie de test est propre à chaque projet.</p>"
        },
		{
            "q": "Java permet de faire du polymorphisme avec des interfaces",
            "a": [
                {"option": "oui",  "correct": true},
                {"option": "non",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> </p>"
        },
		{
            "q": "Quelles sont les classes héritant (directement ou non) de java.lang.Exception ?",
            "a": [
                {"option": "RuntimeException",      "correct": true},
                {"option": "Throwable",             "correct": false},
                {"option": "Error",                 "correct": false},
                {"option": "NullPointerException",  "correct": true}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> NullPointerException hérite de RuntimeException qui hérite de Exception qui lui-même hérite de Throwable. Error hérite de Throwable</p>"
        },
		{
            "q": "Spring offre des fonctionnalités pour :",
            "a": [
                {"option": "faire de l'injection de dépendances avec les annotations @Autowired et @Inject",  "correct": true},
                {"option": "faire de l'inversion de contrôle",  "correct": true},
				{"option": "faire du retour de contrôle",  "correct": false},
                {"option": "faire de la programmation orientée aspect",  "correct": true},
                {"option": "faire de la programmation basée sur la signature des méthodes",  "correct": true}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> @Inject est l'équivalent de @Autowired depuis le JEE6</p>"
        },
		{
            "q": "Quelle est la signification de ORM quand il est lié à Hibernate ?",
            "a": [
                {"option": "Object Rational Mapping",            "correct": false},
                {"option": "Object Role Modeling",               "correct": false},
                {"option": "Object Relational Mapping",         "correct": true},
                {"option": "Observatoire Régional des Métiers",  "correct": false},
                {"option": "Online Reputation Management",       "correct": false},
                {"option": "Object Rational Modeling",           "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Euh...</span> Mapping Objet Relationnel en anglais : Object Relational Mapping</p>"
        },
		{
            "q": "Quelle est la signification de JPA ?",
            "a": [
                {"option": "Java Permanent Application",  "correct": false},
                {"option": "Just Perfect Application",  "correct": false},
                {"option": "Java Persistence API",  "correct": true},
                {"option": "Jeunesse au Plein Air",  "correct": false},
                {"option": "Java Persistence Application",  "correct": false}
            ],
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> Hibernate est un framework de persistance qui implémente JPA qui est l'API de persistance Java (Java Persistence API)</p>"
        },
		{
            "q": "Quels sont, dans cette liste, les types d'objets manipulés dans une base de données relationnelle ?",
            "a": [
                {"option": "colonne",         "correct": true},
                {"option": "clef composite",  "correct": true},
                {"option": "clef étrangère",  "correct": true},
                {"option": "clef publique",   "correct": false},
                {"option": "table",           "correct": true},
                {"option": "chaise",          "correct": false},
                {"option": "clef primaire",   "correct": true},
                {"option": "clef naturelle",  "correct": false},
                {"option": "index",           "correct": true}
            ],
            "correct": "<p><span>Bien joué !</span> On reparlera de clef naturelle durant la formation :)</p>",
            "incorrect": "<p><span>Que peut bien gérer une bdd ? </span> des tables, des colonnes, des clefs primaires, étrangères, composites et des index</p>"
        },
		{
            "q": "Quels sont les liens entre Hibernate et JPA ?",
            "a": [
                {"option": "JPA et Hibernate sont des frameworks complets pour l'ORM",	"correct": false},
                {"option": "JPA est un composant interne d'Hibernate",	"correct": false},
                {"option": "Hibernate propose son API et JPA une autre",  "correct": true},
				{"option": "JPA peut être utilisé avec un autre framework qu'Hibernate",  "correct": true}
            ],
			"force_checkbox": "true",
            "correct": "<p><span>Bien joué !</span> </p>",
            "incorrect": "<p><span>Perdu</span> JPA n'est qu'une API pas un moteur ORM ! JPA est utilisable avec Hibernate, EclipseLink, OpenJPA ou TopLink.</p>"
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
			"select_any": true, permet d'avoir plusieurs bonne réponse possible mais la sélection d'une seule suffit
			"force_checkbox": true, permet d'afficher des selectBox même si une seule bonne reponse n'est disponible (sinon, ceux sont des radioButton)
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
