// All available quiz
var qcm = [];
var qcmLabel = [];

// Selected quiz
var quizJSON;

// On quiz selection
var startQuiz = function() {
	
	// Lecture et validation
	var idQuizSelectionne = $("#selectQcm").val();
	if (!qcm.hasOwnProperty(idQuizSelectionne)) {
		return false;
	}
	
	// Masquage du formulaire de selection
	$(".message").hide();
	
	// Début du quiz
	// DOCUMENTATION : https://github.com/jewlofthelotus/SlickQuiz
	$("#slickQuiz").slickQuiz({
		json: qcm[idQuizSelectionne],
		
		checkAnswerText: "C'est mon dernier mot !",
		nextQuestionText: "Question suivante",
		completeQuizText: "Voyons vos résultats",
		preventUnansweredText: "Vous devez sélectionner une réponse (et peut-être plus)",
		questionCountText: "Question %current sur %total",
		
		randomSortAnswers: true,
		disableRanking: true,
		preventUnanswered: true,
		perQuestionResponseAnswers: true,
		completionResponseMessaging: true
	});
};

$(function () {
	// Initialisation de la liste des quiz
	var selectQcm = document.getElementById("selectQcm");
	for (var key in qcmLabel) {
		var option = document.createElement("option");
		option.text = qcmLabel[key];
		option.value = key;
		selectQcm.add(option);
	}

	// A la selection du quiz
	$("#startQuiz").on("click", startQuiz);
});