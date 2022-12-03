package com.app.geolocalized.tree;

import com.app.geolocalized.model.tree.Tree;
import com.app.geolocalized.model.tree.deciduous.species.Birch;
import com.app.geolocalized.testUtils.TestUtils;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Getter
@Setter
public class BirchDeciduousTreeTest {
    private Tree birch;

    @BeforeEach
    void init() {
        birch = new Birch();
    }

    @Test
    public void whenGetTreeType_thenReturnTreeType() {
        String expectedResult = "Deciduous";

        //when
        String actualResult = getBirch().getTreeType();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void whenGrow_thenReturnMessage() {
        String expectedResult = "Birch had grown";

        //when
        String actualResult = getBirch().grow();

        //then
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void whenGrowBranches_thenReturnMessage() {
        String expectedResult = "Birch had grown 3 new branches";

        //given
        int amount = 3;
        ArrayList<String> branchesID = TestUtils.createNewNamesForBranchesToAdd(amount);

        //when
        String actualResult = getBirch().growBranches(branchesID, amount);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void whenGrowLeavesOnBranch_thenReturnMessage() {
        String expectedResult = "Birch had grown 64 new leaves on branch Branch 1";

        //given
        int leavesAmount = 64;
        int branchesAmount = 3;
        String branchID = "Branch 1";
        ArrayList<String> branchesID = TestUtils.createNewNamesForBranchesToAdd(branchesAmount);
        getBirch().growBranches(branchesID, branchesAmount);

        //when
        String actualResult = getBirch().growLeavesOnBranch(branchID, leavesAmount);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void whenGrowLeavesOnBranchAndSelectedBranchDoesntExist_thenThrowNewNullPointerExceptionAndSendMessage()
            throws NullPointerException {
        String expectedResult = "Selected branch doesn't exist";

        //given
        int leavesAmount = 64;
        int branchesAmount = 3;
        String branchID = "Branch 4";
        ArrayList<String> branchesID = TestUtils.createNewNamesForBranchesToAdd(3);
        getBirch().growBranches(branchesID, branchesAmount);

        //when
        Exception exception = assertThrows(NullPointerException.class, () -> {
            getBirch().growLeavesOnBranch(branchID, leavesAmount);
        });

        //then
        String actualResult = exception.getMessage();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void whenShedAllLeavesFromBranch_thenReturnMessage() {
        String expectedResult = "Birch had shed all leaves from branch Branch 1";

        //given
        int branchesAmount = 3;
        String branchID = "Branch 1";
        ArrayList<String> branchesID = TestUtils.createNewNamesForBranchesToAdd(3);
        getBirch().growBranches(branchesID, branchesAmount);

        //when
        String actualResult = getBirch().shedAllLeavesFromBranch(branchID);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void whenShedAllLeavesFromAllBranches_thenReturnMessage() {
        String expectedResult = "Birch had shed all leaves from all branches";

        //given
        int leavesAmount = 64;
        int branchesAmount = 3;
        ArrayList<String> branchesID = TestUtils.createNewNamesForBranchesToAdd(branchesAmount);
        getBirch().growBranches(branchesID, branchesAmount);

        for(String currentBranchID : branchesID) {
            getBirch().growLeavesOnBranch(currentBranchID, leavesAmount);
        }

        //when
        String actualResult = getBirch().shedAllLeavesFromAllBranches();

        //then
        assertEquals(expectedResult, actualResult);
    }
}
