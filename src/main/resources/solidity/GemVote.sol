pragma solidity ^0.4.16;

contract GemVote {

    struct Voter {
    bool isVoted;
    address delegate;
    }

    struct Proposal {
    address adProposal;
    uint voteCount;
    }


    mapping(address => Voter) public voters;


    Proposal[] public proposals;

    function getVoteCountByAddress(address adProposal) public view returns (uint){
        uint voteCount;

        for (uint i = 0; i < proposals.length; i++) {
            if (proposals[i].adProposal == adProposal) {
                voteCount=proposals[i].voteCount;
            }
        }

        return voteCount;

    }

    function getStatusVoter(address adVoter) public view returns(bool){
        return voters[adVoter].isVoted;
    }


    function addProposal(address adProposal)  returns (bool result) {
        for (uint i = 0; i < proposals.length; i++) {
            if (proposals[i].adProposal == adProposal) {
                return false;
            }
        }

        proposals.push(Proposal({
        adProposal : adProposal,
        voteCount : 0
        }));

        return true;
    }

    function voteUser(address adVoter, address adProposal) returns (bool result) {
        Voter storage voter = voters[adVoter];

        if (voter.isVoted) return false;

        for (uint i = 0; i < proposals.length; i++) {
            if (proposals[i].adProposal == adProposal) {
                proposals[i].voteCount += 1;
                voter.isVoted = false;
            }
        }

        return true;
    }

    function getUserWin() public view returns (address){
        Proposal storage proposalMax = proposals[0];
        for (uint i = 0; i < proposals.length - 1; i++) {

            for (uint j = 1; j < proposals.length; j++) {
                if (proposals[j].voteCount > proposalMax.voteCount) {
                    proposalMax = proposals[j];
                }
            }

        }

        return proposalMax.adProposal;
    }


}