## Simulador de escalonamento de processos FCFS

Projeto desenvolvido na disciplina de Sistemas Operacionais do 7º semestre do curso de Engenharia da Computação do Centro Universitário Católico Salesiano Auxilium no ano de 2015, sob supervisão do professor Rafael Marcelino de Jesus. Linguagem utilizada: Java.

Este software simula o escalonamento de processos FIFO (First-In-First-Out) ou FCFS (First-Come, First Served), que é a forma mais elementar para escalonar processos e consiste em atender as tarefas na ordem em que estas chegam à fila de tarefas prontas. Este projeto une a fila de processos prontos e a fila de  processos bloqueados em uma única fila de processos bloqueados. O algoritmo apresentado representa o modo de escalonamento FCFS cooperativo, no qual o processador executa uma tarefa por vez. Para  melhorar o desempenho, os processos são alocados na memória de acordo sua posição na fila de bloqueados. O processo em execução e os primeiros processos da fila de bloqueados são armazenados na memória principal. Caso a memória principal fique lotada, os últimos processos da fila de bloqueados são armazenados na memória secundária. Para que esta realocação de memória (swap) possa ser executada, é   necessário que haja na memória secundária um espaço igual ou superior ao tamanho do maior processo.

Abaixo, o funcionamento do sistema. Clique na imagem para assistir o vídeo.

[![Watch the video](https://img.youtube.com/vi/TtGq8uVIbuM/hqdefault.jpg)](https://www.youtube.com/watch?v=TtGq8uVIbuM)