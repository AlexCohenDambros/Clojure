; Alex Cohen Dambrós Lopes

;1. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  ultimo  que  receba  uma  lista  e devolva o último elemento desta lista sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.  
(defn ultimo [lista] (reduce (fn [x, y], y) lista))

;2. Utilizando a linguagem Clojure, crie uma função chamada penultimo que receba uma lista e devolva o penúltimo elemento desta lista usar as funções já prontas e disponíveis paraesta mesma finalidade na linguagem Clojure.
(defn penultimo [lista] (reduce (fn [x y] y) (pop lista)))

;3. Utilizando a linguagem Clojure, crie uma função chamada elementoN que receba uma lista e um inteiro N e devolva o elemento que está na posição N desta lista usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.
(defn elementoN [listaInicial posicao] (loop [n_count posicao newLista listaInicial] (if (zero? n_count) (first newLista) (recur (dec n_count) (rest newLista)))))

;4. Utilizando a linguagem Clojure, crie uma função chamada inverso que receba uma lista edevolva esta lista com as posições dos elementos invertidas. Por exemplo recebe [1,2,3] edevolve [3,2,1]. Sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.
(defn inverso [x] (reduce conj '() x))


;5. Utilizando a linguagem Clojure, crie uma função chamada mdc que receba dois inteiros e devolve o mínimo divisor comum entre eles. Sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure. 
(defn mdc [x y] (if (zero? y) x (recur y (mod x y))))

(println (format "Função ultimo; Entrada: %s; Saída: %s"  "[1 2 3 4]" (str (ultimo [1 2 3 4]))))
(println (format "Função penultimo; Entrada: %s; Saída: %s"  "[1 2 3 4]" (str (penultimo [1 2 3 4]))))
(println (format "Função elementoN; Entrada: %s; Saída: %s"  "[1 2 3 4] 1" (str (elementoN [1 2 3 4] 1))))
(println (format "Função inverso; Entrada: %s; Saída: %s"  "[1 2 3 4]" (str (inverso [1 2 3 4]))))
(println (format "Função mdc; Entrada: %s; Saída: %s"  "20 24" (str (mdc 20 24))))