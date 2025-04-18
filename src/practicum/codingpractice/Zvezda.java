package practicum.codingpractice;

class Zvezda extends Zarya {

    public Zvezda() { // доступ к изменению конструктора запрещён
        super();
        energyConsumption = 44;
        activateModule();
    }
    // доступ к созданию новых конструкторов запрещён

    // разрешено переопределение методов
    @Override
    void activateModule() {
        turnSolarPanels(); // Попытка накопить энергию
    }
    @Override
    void stabilize() { // Стабилизируем малым двигателем
        stabilizeBySmallEngines();
    }
}
