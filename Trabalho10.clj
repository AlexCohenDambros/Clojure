; Alex Cohen Dambrós Lopes


; 1. Na  aula  disponível  em:  https://replit.com/@frankalcantara/ClojureAula2?v=1  foram destacadas diversas funções (expressões), como funções de primeira ordem, disponíveis em Clojure.  Sua  primeira  tarefa  será  descrever  cada  uma  destas  funções  e  apresentar dois exemplos  de  uso  de  cada  uma  delas.  Lembre-se  os  exemplos  precisam  ser  utilizados  de forma que o resutado da função possa ser visto no terminal.  

; assoc -> é uma função que é ligada a um map que retorna um novo map de mesmo tipo que contem o mapeamento de chave e valor.

(println "Função assoc exemplo 1; entrada: [1 2 3] 0 10; resultado: "(assoc [1 2 3] 0 10))
(println "Função assoc exemplo 2; entrada: [1 2 3] 3 10; resultado: "(assoc [1 2 3] 3 10))

; dissoc -> é uma função que que é ligada a um map que retorna um novo map que não contém um mapemanto por chave. 

(println "Função dissoc exemplo 1; entrada: {:a 1 :b 2 :c 3} :b; resultado: "(dissoc {:a 1 :b 2 :c 3} :b))
(println "Função dissoc exemplo 2; entrada: {:a 1 :b 2 :c 3} :c :b; resultado: "(dissoc {:a 1 :b 2 :c 3} :c :b))

; range -> é uma função que cria uma sequencia de valores que se inicia em 0 e vai até um determinado valor dado, podendo passar dois parametros no qual o primeiro seria o inicio dos valores e o segundo o término.

(println "Função range exemplo 1; entrada: 5; resultado: "(range 5))
(println "Função range exemplo 2; entrada: 15 20; resultado: "(range 15 20))

; map -> é uma função que retorna uma sequencia que consiste no resultado da aplicação de f ao conjunto dos primeiros itens de cada col, seguido pela aplicação de f ao conjunto de segundos itens em cada coll.

(println "Função map exemplo 1; entrada: [10 5 8] [11 14 5]; resultado: "(map + [10 5 8] [11 14 5]))
(println "Função map exemplo 2; entrada: [10 5 8] [5 5 5]; resultado: "(map * [10 5 8] [5 5 5]))

; inc -> é uma função que retorna um número maior do que um número dado.

(println "Função inc exemplo 1; entrada: 9; resultado: "(inc 9))
(println "Função inc exemplo 2; entrada: [1 2 3]; resultado: "(map inc [1 2 3]))

; filter -> é uma função que retorna uma sequencia do item passado como parametro para os quais retorna logical true. 

(println "Função filter exemplo 1; entrada: 10; resultado: " (filter even? (range 10)))
(println "Função filter exemplo 2; entrada: 10; resultado: " (filter odd? (range 10)))

; into -> é uma função que retorna uma saida onde ocorreu o uso de todos os itens passados no parametro.

(println "Função into exemplo 1; entrada: 1 2, 3 4}; resultado: "(into [] {1 2, 3 4}))
(println "Função into exemplo 2; entrada: [1 2 3] '(4 5 6); resultado: "(into [1 2 3] '(4 5 6)))


; nth -> é uma função que retorna o valor no indíce passado como parametro.

(def valores ["a", 2, "b", 3])

(println "Função nth exemplo 1; entrada: 2; resultado: " (nth valores 2))
(println "Função nth exemplo 2; entrada: 3; resultado: " (nth valores 3))

; conj -> é uma função que retorna a adição de valores passados como parametro em uma coleção.

(println "Função conj exemplo 1; entrada: [1 2 3] 4; resultado: " (conj [1 2 3] 4))
(println "Função conj exemplo 2; entrada: [1 2] 3 4; resultado: " (conj [1 2] 3 4))

; sort -> é uma função que dada uma coleção o retona ordenada como padrão de forma crescente.

(println "Função sort exemplo 1; entrada: [3 1 2 4]; resultado: " (sort [3 1 2 4]))
(println "Função sort exemplo 2; entrada: [b c a]; resultado: " (sort ["b" "c" "a"]))

; partition-by -> é uma função que retorna uma sequência de partições de uma coleção dada.

(println "Função partition-by exemplo 1; entrada: [1 1 1 2 2 3 3]; resultado: " (partition-by odd? [1 1 1 2 2 3 3]))
(println "Função partition-by exemplo 2; entrada: [1 1 1 2 2 3 3]; resultado: " (partition-by even? [1 1 1 2 2 3 3]))

; empty -> é um função que retorna true caso a coleção passada como parametro esteja vazia e false para caso não esteja. 

(println "Função empty exemplo 1; entrada: (); resultado: " (empty? ()))
(println "Função empty exemplo 2; entrada: '(1); resultado: " (empty? '(1)))

; count -> é uma função que retorna o retorna o numero de itens de uma coleção.

(println "Função count exemplo 1; entrada: []; resultado: " (count []))
(println "Função count exemplo 2; entrada: [1 2 3]; resultado: " (count [1 2 3]))

; char - é uma função que retorna o char equivalente índice dado. 

(println "Função char exemplo 1; entrada: 97; resultado: " (char 97))
(println "Função char exemplo 2; entrada: [65 66 67 68]; resultado: " (map char [65 66 67 68]))

; 2. Utilizando a linguagem Clojure, crie uma função chamada ehPrimo que receba um inteiro e devolva True caso este inteiro seja verdadeiro e False caso contrário. 

(defn ehPrimo? [valor] (
  loop [atual 1 lista []]
       (if (= atual (+ valor 1)) (if (= (count lista) 2) true false)
       (recur (inc atual) (if (zero? (mod valor atual)) (conj lista atual) lista)))
                   
))

(println "Função ehPrimo; entrada: 53; resultado: " (str (ehPrimo? 53)))

; 3. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  fatoresPrimos  que  receba  um inteiro e devolva uma lista dos seus fatores primos. Decomposição em fatores primos é uma tarefa fundamental da aritmética.
(defn isPrimo [x n]
  (if (= x n) true (if (= (mod x n) 0) false (isPrimo x (+ n 1)))))

(defn nextPrimoDivisor [x n]
  (if (false? (isPrimo n 2)) 
    (nextPrimoDivisor x (+ n 1))
    (if (= (mod x n) 0)
      n
      (nextPrimoDivisor x (+ n 1)))))

(defn fatoresPrimos [x]
  (if (true? (isPrimo x 2)) [x] (concat [(nextPrimoDivisor x 2)] (fatoresPrimos (/ x (nextPrimoDivisor x 2))))))

(println "Função fatoresPrimos; entrada: 520; resultado: " (fatoresPrimos 520))

; 4. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  todosPrimos  que  receba  dois valores inteiros e devolve todos os números primos que existam entre estes dois valores.
(defn todosPrimos [x y] (
   loop [lista (range x (+ y 1)) lista2 []]
      (if (empty? (rest lista)) lista2 (recur (rest lista) (if (ehPrimo? (nth lista 0)) (conj lista2 (nth lista 0)) lista2)))
))

(println "Função todosPrimos; entrada: 10 100; resultado: " (str (todosPrimos 10 100)))