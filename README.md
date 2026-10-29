# Algoritmo Genético Orientado a Objetos em Java para otimizar a função \(f(x)=2x\)

## 1. Descrição do projeto

Este projeto implementa um algoritmo genético em Java utilizando o paradigma de programação orientada a objetos (POO). A implementação distribui as responsabilidades entre classes que representam o algoritmo, uma população de indivíduos, os cromossomos e os genes.

O algoritmo utiliza cromossomos binários para representar possíveis soluções e uma função de avaliação que atribui a cada cromossomo o valor:

\[
f(x) = 2x
\]

em que \(x\) é o valor decimal correspondente à sequência binária do cromossomo.

A cada geração, os indivíduos são selecionados por roleta, combinados por crossover de um ponto e submetidos à mutação. O programa apresenta estatísticas das populações e, ao final, exibe os dados do melhor cromossomo da última população.

## 2. Objetivos

- Demonstrar a organização de um algoritmo genético com classes e objetos.
- Representar indivíduos por cromossomos formados por genes binários.
- Inicializar uma população aleatória.
- Avaliar os cromossomos por uma função de aptidão.
- Selecionar indivíduos por roleta.
- Gerar descendentes por crossover de um ponto.
- Aplicar mutação aos genes dos descendentes.
- Exibir estatísticas de cada geração e identificar o melhor cromossomo da população final.

## 3. Organização orientada a objetos

A implementação está dividida em cinco classes Java:

| Classe | Responsabilidade |
|---|---|
| `Principal` | Configura os parâmetros do algoritmo e inicia sua execução. |
| `AlgoritmoGenetico` | Controla as gerações, mantém o histórico de populações e coordena a execução. |
| `Populacao` | Gerencia os cromossomos e implementa inicialização, avaliação, seleção por roleta, crossover, geração de descendentes e estatísticas. |
| `Cromossomo` | Representa um indivíduo como uma sequência de genes, converte a sequência binária em decimal, calcula a avaliação e aplica mutação. |
| `Gene` | Representa um alelo binário e permite alternar seu valor entre `0` e `1`. |

### 3.1. Relacionamento entre as classes

- `Principal` cria e configura um objeto `AlgoritmoGenetico`.
- `AlgoritmoGenetico` cria e processa objetos `Populacao`.
- Cada `Populacao` mantém uma lista de objetos `Cromossomo`.
- Cada `Cromossomo` mantém uma lista de objetos `Gene`.
- A classe `Gene` encapsula o valor do alelo.

Essa organização separa as responsabilidades e torna o código mais modular, facilitando a compreensão e a manutenção.

## 4. Representação dos indivíduos

Cada cromossomo é formado por quatro genes na configuração fornecida pela classe `Principal`. Cada gene pode assumir os valores `0` ou `1`.

Exemplo de cromossomo:

| Representação binária | Valor decimal \(x\) | Avaliação \(f(x)=2x\) |
|---|---:|---:|
| `1010` | 10 | 20 |

Com quatro bits, os cromossomos podem representar valores inteiros de `0` a `15`. Como a avaliação é \(f(x)=2x\), o maior valor possível para essa configuração é `30`, correspondente ao cromossomo `1111`.

## 5. Função de avaliação

A função implementada no método `getAvaliacao()` da classe `Cromossomo` é:

\[
f(x) = 2x
\]

O valor \(x\) é obtido pela conversão da sequência de genes, interpretada como número binário, para um número decimal. A avaliação é utilizada para calcular a soma das aptidões da população, estimar probabilidades na estatística apresentada e orientar a seleção por roleta.

## 6. Parâmetros de execução

A classe `Principal` configura os seguintes valores:

| Parâmetro | Valor | Significado |
|---|---:|---|
| `quantidadeGeracoes` | 12 | Número de novas gerações produzidas após a população inicial. |
| `tamanhoPopulacao` | 8 | Quantidade de cromossomos em cada população. |
| `tamanhoCromossomo` | 4 | Quantidade de genes por cromossomo. |
| `percentualMutacao` | `0.05` (5%) | Probabilidade passada ao método de mutação para cada gene. |

A população inicial é criada antes do laço de gerações. Portanto, o histórico pode conter a população inicial mais as 12 populações produzidas durante a execução, totalizando 13 populações.

## 7. Etapas do algoritmo

1. **Configuração:** a classe `Principal` define os parâmetros e chama `executa()`.
2. **População inicial:** a classe `AlgoritmoGenetico` cria uma população e inicializa os cromossomos com genes aleatórios.
3. **Avaliação:** cada cromossomo recebe uma avaliação calculada por \(f(x)=2x\), e a população armazena a soma das avaliações.
4. **Estatísticas:** são impressos o índice, a sequência binária, o valor decimal, a avaliação, a probabilidade e um índice sorteado pela roleta.
5. **Seleção:** a roleta utiliza a avaliação dos cromossomos para escolher os índices dos dois indivíduos que serão os progenitores.
6. **Crossover:** o método `crossoverUmPonto()` combina os genes dos progenitores a partir de um ponto de corte aleatório.
7. **Mutação:** o método `mutacao()` percorre os genes do descendente e, conforme a probabilidade informada, chama `mutar()` para inverter o alelo.
8. **Nova população:** os descendentes são reunidos em uma nova população, que é avaliada e apresentada.
9. **Resultado:** ao terminar as gerações configuradas, o programa apresenta o melhor cromossomo da última população.

## 8. Métodos importantes

| Classe | Método | Finalidade |
|---|---|---|
| `AlgoritmoGenetico` | `executa()` | Coordena a execução do algoritmo genético. |
| `AlgoritmoGenetico` | `adicionaPopulacao()` | Adiciona uma população ao histórico de gerações. |
| `AlgoritmoGenetico` | `getUltimaPopulacao()` | Recupera a última população armazenada. |
| `Populacao` | `inicializaPopulacao()` | Cria cromossomos e gera seus genes aleatoriamente. |
| `Populacao` | `avaliaCromossomos()` | Calcula a soma das avaliações dos cromossomos. |
| `Populacao` | `getNumeroRoleta()` | Sorteia um índice com base nas avaliações da população. |
| `Populacao` | `crossoverUmPonto()` | Produz um cromossomo descendente a partir de dois progenitores. |
| `Populacao` | `geracao()` | Constrói uma nova população aplicando crossover e mutação. |
| `Populacao` | `getMelhorCromossomo()` | Retorna o índice do cromossomo com maior avaliação. |
| `Populacao` | `mostraEstatisticas()` | Exibe os dados e as probabilidades dos cromossomos. |
| `Cromossomo` | `gerarGenesAleatorios()` | Gera alelos aleatórios. |
| `Cromossomo` | `getGeneString()` | Retorna a sequência de genes como texto binário. |
| `Cromossomo` | `converteBinarioParaDecimal()` | Converte a sequência binária em inteiro. |
| `Cromossomo` | `getAvaliacao()` | Calcula a avaliação do cromossomo. |
| `Cromossomo` | `mutacao()` | Tenta mutar cada gene conforme a probabilidade informada. |
| `Gene` | `mutar()` | Inverte o alelo entre `0` e `1`. |

## 9. Tecnologias utilizadas

- **Java 8 ou compatível:** linguagem de programação utilizada na implementação.
- **Programação Orientada a Objetos:** classes, objetos, atributos, métodos e encapsulamento.
- **Collections Framework:** `List` e `LinkedList` para armazenar genes, cromossomos e populações.
- **`java.util.Random` e `Math.random()`:** geração de valores aleatórios.
- **Maven (opcional):** pode ser utilizado para organizar e compilar o projeto caso exista um `pom.xml` configurado.

## 10. Requisitos

- JDK instalado e configurado.
- Arquivos-fonte das cinco classes no mesmo diretório, caso não estejam organizados em pacotes.
- Maven somente se o projeto for executado por meio de uma configuração Maven existente.

Verifique a versão do Java com:

```bash
java -version
javac -version
```

## 11. Estrutura dos arquivos

```text
src/main/java/
├── Principal.java
├── AlgoritmoGenetico.java
├── Populacao.java
├── Cromossomo.java
└── Gene.java
```

Os nomes dos arquivos devem corresponder aos nomes das classes públicas. O arquivo enviado como `Principal(4).java` deve ser renomeado para `Principal.java` antes de compilar com `javac`.

## 12. Compilação e execução

### 12.1. Compilar com `javac`

No diretório que contém os cinco arquivos `.java`, execute:

```bash
javac Principal.java AlgoritmoGenetico.java Populacao.java Cromossomo.java Gene.java
```

Depois, execute:

```bash
java Principal
```

### 12.2. Utilizar Maven

Se o projeto possuir um `pom.xml` configurado, compile com:

```bash
mvn clean package
```

A execução com `mvn exec:java` depende da configuração do plugin Maven Exec e da classe principal no `pom.xml`. Como o arquivo `pom.xml` não foi fornecido, não é possível confirmar o comando Maven específico para executar este projeto.

## 13. Saída esperada

A saída é textual e varia a cada execução, pois a população inicial, os pontos de corte, a seleção e a mutação utilizam aleatoriedade. O programa apresenta:

- Estatísticas da população inicial.
- Uma mensagem de cálculo para cada nova geração.
- Estatísticas de cada população produzida.
- Índice, cromossomo binário, valor decimal e avaliação do melhor cromossomo da última população.

O resultado não é determinístico: execuções diferentes podem produzir sequências e resultados diferentes.

## 14. Observações sobre a implementação

- A função de avaliação \(f(x)=2x\) cresce conforme o valor decimal representado pelo cromossomo. Para quatro genes, `1111` representa o valor máximo `15` e recebe avaliação `30`.
- A mutação percorre cada gene e, quando `Math.random()` é menor que `percentual`, inverte o alelo. Com `0.05`, cada gene tem uma probabilidade nominal de 5% de sofrer mutação.
- O método `gerarGenesAleatorios()` adiciona genes aleatórios ao cromossomo. Como o construtor de `Cromossomo` já cria uma quantidade de objetos `Gene` igual ao tamanho configurado, esse método acrescenta novos genes em vez de substituir os existentes. **Isso pode fazer com que os cromossomos inicializados tenham o dobro do número de genes esperado.** A conversão binária e o crossover, por sua vez, consideram o tamanho configurado em partes do código; esse comportamento deve ser revisado antes de usar os resultados como referência experimental.
- O método `getNumeroRoleta()` percorre a lista usando `getTamanho()`, que é o tamanho configurado da população. O código pressupõe que esse valor corresponde à quantidade real de cromossomos armazenados.
- A estatística calcula a probabilidade dividindo a avaliação de cada cromossomo pela soma das avaliações. Se a soma for zero, a divisão não produz probabilidades úteis.
- O ponto de corte do crossover pode ser zero; nesse caso, um dos progenitores pode fornecer todos os genes do descendente, conforme a orientação sorteada.

## 15. Limitações

Este código tem finalidade didática e demonstra os componentes básicos de um algoritmo genético orientado a objetos. Antes de utilizá-lo em experimentos ou aplicações reais, recomenda-se revisar a inicialização dos genes, garantir a consistência entre os tamanhos configurados e as listas efetivamente armazenadas, tratar a soma de avaliações igual a zero e validar os resultados do processo evolutivo.

