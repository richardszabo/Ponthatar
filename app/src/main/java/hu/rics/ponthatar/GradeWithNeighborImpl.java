package hu.rics.ponthatar;

import lombok.Getter;
import lombok.Setter;

class GradeWithNeighborImpl extends GradeImpl implements GradeWithNeighbor {
    @Getter @Setter
    Grade lowerNeighbor = new GradeImpl();

    @Override
    public void setMinimalPercentage(int minimalPercentage) {
        super.setMinimalPercentage(minimalPercentage);
        lowerNeighbor.setMaximalPercentage(minimalPercentage-1);
    }
}
