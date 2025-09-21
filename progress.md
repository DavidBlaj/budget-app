1.9   - Ich habe die Methodennamen geändert, indem ich den Klassennamen hinzugefügt habe, da es im Frontend Probleme 
        mit der OpenAPI-Codegenerierung gab.
      - Außerdem habe ich „expenseCategory“ in „category“ in „ExpenseDTO“ geändert, da es Probleme mit OpenAPI zu 
        geben schien.
      - Außerdem habe ich „optional=false“ zu „incomeCategory“ und „expenseCategory“ hinzugefügt, um sicherzustellen, 
        dass im Frontend keine „undefinierten“ Fehler auftreten.

1.9.1 - Ich habe dem Projekt die Datei progress.md hinzugefügt.

1.10  - In order to have better error handling, Spring Profiles were added: "dev" and "prod" for now
      - "GlobalExceptionHandler" Datei wurde hinzugefügt.

1.FINAL - Ich habe alles gelöscht, was mit dem aktuellen Modell zusammenhängt. 
        - Ich bereite mich auf die nächste version der App vor.

2.0 - New models are going to be created for the application: User, CustomCategory, StandardCategory, Transaction
2.1 Create repositories for the model, and fix Transaction model
2.2 Ich habe für "User" Modell Service und Controller hinzugefügt. 
    Außerdem habe ich auch kleinere Änderungen and den anderen Modellen vorgenommen.

2.3 Ich habe für "StandardCategory" Modell Service und Controller hinzugefügt. 