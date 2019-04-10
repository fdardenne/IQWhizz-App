select questionID from TestQuestions
where questionID not in (select questionID from SelectedAnswers where testExecutionID in
                                                                      (select testExecutionID from TestExecutions where username='Hadrien' and testID=1))
and testID=1;

select T.testID, T.type, (case count(DISTINCT Qu.Category) WHEN 1 THEN Qu.Category ELSE "Random" END), count(Q.questionID) 
FROM testQuestions Q, Questions Qu, Tests T 
WHERE T.testID = Q.testID and Qu.questionID=Q.questionID GROUP BY T.testID;
