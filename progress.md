1.9   - Ich habe die Methodennamen geändert, indem ich den Klassennamen hinzugefügt habe, da es im Frontend Probleme 
        mit der OpenAPI-Codegenerierung gab.
      - Außerdem habe ich „expenseCategory“ in „category“ in „ExpenseDTO“ geändert, da es Probleme mit OpenAPI zu 
        geben schien.
      - Außerdem habe ich „optional=false“ zu „incomeCategory“ und „expenseCategory“ hinzugefügt, um sicherzustellen, 
        dass im Frontend keine „undefinierten“ Fehler auftreten.