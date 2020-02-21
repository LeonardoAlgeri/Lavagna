# Lavagna
Una semplice lavagna su cui poter scrivere.  
Frontend: https://gitlab.com/Leonardoalgeri/lavagnafrontend  
Backend: https://github.com/LeonardoAlgeri/Lavagna  
DockerHub: https://hub.docker.com/r/leonardoalgeri/lavagna

## API
Il backend mette a disposizione le seguenti chiamate:
- **/all** Restituisce tutti gli elementi scritti sulla lavagna
- **/add** Aggiunge un messaggio alla lavagna (tramite una richiesta POST)
- **/reset** Resetta la lavagna (API temporanea da migliorare)

## Deploy
In fase di deploy è necessario fornire all'applicativo le seguenti varibili d'ambiente:
- Per il database mysql  
  - **SQL_URL** il link dell'host sql seguito da porta e nome del database. Ad esempio host:port/mydatabase
  - **SQL_USER** l'utente del database sql 
  - **SQL_PASSWORD** la password del database sql
- Generiche
  - **PASS_RESET** la password da utilizzare con l'api /reset
  
## Docker
È possibile eseguire il seguente programma su docker seguendo questi passi:
1) Settare un file env.list contentente il valore delle variabili d'ambiente. Trovate un esempio [qui](https://docs.docker.com/engine/reference/commandline/run/)  cercando **env**  
2) Eseguire le seguenti istruzioni

    ```
    docker run --env-file env.list -dp 8080:8080 --name lavagna --restart always leonardoalgeri/lavagna
    ```
3) Attendere qualche minuto per l'avvio di spring

Per fermare il container è sufficente la seguente operazione
    ```
    docker stop lavagna
    ```


## Warning
In caso di problemi con la visualizzazione di emoji sulla lavagna controllare che la codifica del database sia **utf8mb4_0900_ai_ci**
