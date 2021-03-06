## 도메인 특화언어

* 규모가 작고 무언가에 특화되었으며 효율적으로 개발하고자 할때, 도메인 특화 언어(Domain-Specific Language)가 요구될 때가 있다.
* <DSL : 고객과 함께하는 도메인 특화언어> 라는 책으로 개념을 잡을필요가 있다.
* CSS, XML, Gradle, Rake, React JSX 등은 사실 DSL 라고 부를 수 있다.
* 당장에 개념을 완벽하게 이해하는 것에 초점을 두기보다, 설계시 고려사항에 중점을 두어 학습한다.

## DSL의 타입과 특징

### 외부DSL
* 외부 DSL을 선택 시 자유도가 보장되나, DSL을 위한 Phaser를 만들어야하고 유연성과 제약사항의 균형을 잘 맞춰야한다.
  * CSS, ANT 빌드파일, MAKE 빌드파일 등이 해당된다.
* 내부 DSL 혹은 임베디드 DSL을 선택 시, 해당 언어의 컴파일러와 툴이 파서의 역활을 하므로 수고가 덜어진다. 그러나 자연스러움과 표현력을 확보하고 특정기능을
  구현하려면 창의성과 트릭이 요구된다.
  * Rake 빌드파일, Gradle 빌드파일 등이 해당된다.