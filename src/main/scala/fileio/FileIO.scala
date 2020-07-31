package fileio
import java.nio.file.Files.copy
import java.nio.file.Paths.get
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

object FileIO {
  def copyFile(oldName: String, newName: String) = {
    def toPath(s: String) = get(s)

    copy(toPath(oldName), toPath(newName), REPLACE_EXISTING)
  }

}
