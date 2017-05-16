package hu.rics.ponthatar;

public enum TestPaperType {
    TEMAZARO(40,55,70,85),
    SZODOLGOZAT(51,64,77,90);
    int grade2MinimalPercentage;
    int grade3MinimalPercentage;
    int grade4MinimalPercentage;
    int grade5MinimalPercentage;
    TestPaperType(int grade2MinimalPercentage,
                  int grade3MinimalPercentage,
                  int grade4MinimalPercentage,
                  int grade5MinimalPercentage) {
        this.grade2MinimalPercentage = grade2MinimalPercentage;
        this.grade3MinimalPercentage = grade3MinimalPercentage;
        this.grade4MinimalPercentage = grade4MinimalPercentage;
        this.grade5MinimalPercentage = grade5MinimalPercentage;
    }
}
