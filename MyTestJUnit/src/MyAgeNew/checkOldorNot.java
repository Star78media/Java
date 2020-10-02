package MyAgeNew;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
	class checkOldorNot {

		@Test
		void youngAshell() {
			int Young = 17;	
			MyAge ageVerification = new MyAge();
			assertTrue(ageVerification.isyoungashell(Young));	//if true, i´m young as hell
		}
		@Test
		void OldAsHell() {
			int Adult = 18;
			MyAge ageVerification = new MyAge();
			assertTrue(ageVerification.isyoungashell(Adult));	//if false, i´m not old
		}

	}

