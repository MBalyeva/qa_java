# qa_java — Sprint 6

Учебный проект: юнит-тесты классов Animal, Cat, Feline, Lion.

## Что сделано
- Написаны юнит-тесты для классов Animal, Cat, Feline, Lion.
- Cat и Feline протестированы с параметризацией (getFood, getKittens).
- Lion изолирован от Feline через интерфейс FelineBehavior, зависимости замоканы через Mockito.

## Запуск

Для запуска тестов и сборки отчёта JaCoCo выполните:

```bash
mvn clean verify
